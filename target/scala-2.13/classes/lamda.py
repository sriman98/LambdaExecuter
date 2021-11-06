# Lambda function to be deployed in AWS lambda function
import json
import boto3
import hashlib

s3=boto3.client('s3')

#Function to get the time timestamp of a particular log in integer format so that they can be compared
def intify(log):
    timestamp=log[:8]
    a=timestamp.split(":")
    return int(a[0])*10000+int(a[1])*100+int(a[2])

#Main function for Lambda
def lambda_handler(event, context):
    #get the log file from S3 bucket
    bucket='bucketoflogz'
    key='log.log'
    logs = s3.get_object(Bucket=bucket,Key=key)
    content=logs['Body'].read().decode('utf-8').splitlines()

    #get the T and DT parameters from the GET request
    timeMean = event['queryStringParameters']['T']
    dT= event['queryStringParameters']['dT']

    times=timeMean.split(":")
    dTs=dT.split(":")

    if(len(times)!=3 or len(dTs)!=3):
        return {
        'statusCode': 404,
        'headers':{},
        'body': json.dumps("Sorry Bro")
        }

    #Get the T+DT string through what's available to us
    tplus=""
    hours=int(times[0])+int(dTs[0])
    minutes=int(times[1])+int(dTs[1])
    seconds=int(times[2])+int(dTs[2])
    if(seconds>=60):
        seconds=seconds-60
        minutes=minutes+1
    if(minutes>=60):
        minutes=minutes-60
        hours=hours+1
    if(hours>=24):
        hours=23
        minutes=59
        seconds=59
    tplus=str(hours)+":"
    tplus=tplus+str(minutes)+":"
    tplus=tplus+str(seconds)


    #Compute T-DT string
    tminus=""
    hours=int(times[0])-int(dTs[0])
    minutes=int(times[1])-int(dTs[1])
    seconds=int(times[2])-int(dTs[2])
    if(seconds<0):
        seconds=seconds+60
        minutes=minutes-1
    if(minutes<0):
        minutes=minutes+60
        hours=hours-1
    if(hours<0):
        hours=0
        minutes=0
        seconds=0
    tminus=str(hours)+":"
    tminus=tminus+str(minutes)+":"
    tminus=tminus+str(seconds)


    #Get integer value for T+DT and T-DT for comparision purposes in the future
    a=tminus.split(":")
    integertminus=int(a[0])*10000+int(a[1])*100+int(a[2])

    a=tplus.split(":")
    integertplus=int(a[0])*10000+int(a[1])*100+int(a[2])


   #Start binary search algorithm
    start=0
    end=len(content)-1
    min=intify(content[end])
    min_index=end

    if(integertminus>intify(content[end]) or integertplus<intify(content[start])):
        return {
        'statusCode': 404,
        'headers':{},
        'body': json.dumps("Sorry Bro")
        }
    if(integertminus<intify(content[start])):
        integertminus=intify(content[start])
    if(integertplus>intify(content[end])):
        integertplus=intify(content[end])
    #Get minimum value greater than T-DT in the logs
    while(True):
        if(start>end):
            break
        mid=int((start+end)/2)
        if(intify(content[mid])==integertminus):
            min=intify(content[mid])
            min_index=mid
            break
        if(intify(content[mid])>integertminus):
            end=mid-1
            min=intify(content[mid])
            min_index=mid
            if(intify(content[mid-1])>min):
                min=intify(content[mid-1])
                min_index=mid-1
        if(intify(content[mid])<integertminus):
            start=mid+1
    #Get maximum value less than T+DT in the logs
    start=0
    end=len(content)-1
    max=intify(content[start])
    max_index=start
    while(True):
        if(start>end):
            break
        mid=int((start+end)/2)
        if(intify(content[mid])==integertplus):
            max=intify(content[mid])
            max_index=mid
            break
        if(intify(content[mid])>integertplus):
            end=mid-1
        if(intify(content[mid])<integertplus):
            start=mid+1
            max=intify(content[mid])
            max_index=mid
            if(intify(content[mid+1])<max):
                max=intify(content[mid+1])
                max_index=mid+1
    #if the min and max are not in ascending order that means there are no logs in the interval
    if(min_index>max_index):
        return {
        'statusCode': 404,
        'headers':{},
        'body': json.dumps("Sorry Bro")
        }
    #Get the logs between the time interval by using min and max computed before and return the logs
    shortlist=content[min_index:max_index+1]
    final=[]
    #Encode it using MD5
    for ele in shortlist:
        final.append(str(hashlib.md5(ele.encode())))
    return {
        'statusCode': 200,
        'headers':{},
        'body': json.dumps(final)
    }