## Sriman Cherukuru

## Summary

This Project is to process the log files generated as an output of the Project: LogFileGenerator(https://github.com/0x1DOCD00D/LogFileGenerator/) which generates random logs in sequantial order with timestamps. This repository contains a pair of Client programs implemented using Akka and GRPC respectively.
The GRPC program also has a server which on request in-turn requests the central server for processing the data and replies to the GRPC client.
The GRPC client and Server communicate using protobuffs which are configured in the 'protobuf' repository. The central server is actually a AWS lambda that serves to the request given via a REST protocol.
The AWS lambda is configured to listen to a 'GET' requestwhich is being invoked in the GRPC server and the AKKA client.
The AWS lambda function in turn has to be given a privilege to access S3 bucket where the logs are stored.
The logs are stored into the S3 bucket by running an EC2 instance of the project 'LogFileGenerator' and having the S3 bucket as the target storage.

## Prerequisites

* Install SBT to execute the project LambdaExecuter
* AWS account to run EC2 instance of LogFileGenerator, S3 bucket to store logs and AWS lambda to execute the code
## Installation

* Clone the GIT repository by using git clone https://github.com/sriman98/LambdaExecuter.git
* One Additional step is required to ensure smooth execution. In File -> Project Structure->Modules -> Lambda Executer->Sources, Make sure that the path target\..\main is removed. Else an error will occur while execution
* Run the following command in the console

```
sbt clean compile test
```
* It builds and compiles the project
* If you are using IntellIj clone the repository by using "Check out from Version Control and then Git."

* The scala version should be set in the Global Libraries under Project Structure in Files .
* The SBT configuration should be added by using Edit Configurations and then simulations can be ran in the IDE .
* 
## Execution

```
sbt "runMain Grpc.GrpcServer"
```
Additionally in a new terminal, execute this command
```
sbt "runMain Grpc.GrpcClient"
```
This will invoke the Client and Server methods of the GRPC protocol implementation.
To run the AKKA Client implementation, execute the following command
```
sbt "runMain AkkaClient"
```
This method will run the Akka client and fetch the result from the AWS lambda.

### Output
In the Akka Client, When the code is executed, the following Type of Output is observed
```
17:43:28.597 [default-akka.actor.default-dispatcher-4] INFO  akka.event.slf4j.Slf4jLogger - Slf4jLogger started
17:43:30.904 [default-akka.actor.default-dispatcher-8] INFO  java.lang.Class - Akka Client: Connected to AWS end point to process the Lambda
17:43:30.904 [default-akka.actor.default-dispatcher-8] INFO  java.lang.Class - Status Code: 200 OK
17:43:30.912 [default-akka.actor.default-dispatcher-4] INFO  java.lang.Class - ["16:30:33.095 [run-main-0] WARN  HelperUtils.Parameters$ - Max count 100 is used to create records instead of timeouts", "16:30:33.748 [scala-execution-context-global-67] WARN  HelperUtils.Parameters$ - s%]s,+2k|D}K7b/XCwG&@7HDPR8z", "16:30:34.566 [scala-execution-context-global-67] INFO  HelperUtils.Parameters$ - ;kNI&V%v<c#eSDK@lPY(", "16:30:35.348 [scala-execution-context-global-67] INFO  HelperUtils.Parameters$ - l9]|92!uHUQ/IVcz~(;.Uz%K*5jTUd08", "16:30:35.669 [scala-execution-context-global-67] INFO  HelperUtils.Parameters$ - G3sw7^U<^q^Cl!aMTDbNz<:$;?e<.0JD_'", "16:30:36.500 [scala-execution-context-global-67] WARN  HelperUtils.Parameters$ - A><YFqpg+~\"E1T", "16:30:36.841 [scala-execution-context-global-67] DEBUG HelperUtils.Parameters$ - JrQB;P0\"&+6;&Dk-", "16:30:37.523 [scala-execution-context-global-67] INFO  HelperUtils.Parameters$ - OsI1`qAeU5H;\\+", "16:30:37.943 [scala-execution-context-global-67] INFO  HelperUtils.Parameters$ - [h!Q9PEY>L(NpKLBO\"Gjo:=4kRXQ_tZ!", "16:30:38.418 [scala-execution-context-global-67] INFO  HelperUtils.Parameters$ - B?y&C\"C5rsb:2037;f&|vM#x?z|Ny|&<44Z8B&rF1#&M", "16:30:38.702 [scala-execution-context-global-67] WARN  HelperUtils.Parameters$ - x2oBSI0/\\%CdfV2%ChSsnZ7vJo=2qJqZ%.\"kbc!0ne`y&m", "16:30:38.885 [scala-execution-context-global-67] ERROR HelperUtils.Parameters$ - ihu}!A2]*07}|,lc", "16:30:39.873 [scala-execution-context-global-67] INFO  HelperUtils.Parameters$ - CC]>~R#,^#0JWyESarZdETDcvk)Yk'I?", "16:30:40.102 [scala-execution-context-global-67] WARN  HelperUtils.Parameters$ - Swq;g+6M:?820=Gmd#.p)sFaqoKc^mm](.A8Z-4-].tp|cfR\\~rc(m^{", "16:30:40.980 [scala-execution-context-global-67] INFO  HelperUtils.Parameters$ - zXK=Fze%-6Iv-^q{zhG|EUzvd);tOj-:", "16:30:41.818 [scala-execution-context-global-67] INFO  HelperUtils.Parameters$ - ^<A>61@{3[KEk@M/Xh-q%sco3Dkwq~", "16:30:42.363 [scala-execution-context-global-67] WARN  HelperUtils.Parameters$ - Bv^B8Re'$VG)[P\".g*?f<G\\l5n.18B|i<E&rgPQZ;wBeA{4O/fy+Pp", "16:30:43.235 [scala-execution-context-global-67] WARN  HelperUtils.Parameters$ - k1H+R#/%d0>Q>N:6\\enT]U", "16:30:43.594 [scala-execution-context-global-67] INFO  HelperUtils.Parameters$ - 8G;,3m_T`G#H]&Yh:Ei1%fp''5`M8ube0J6vbf3bf3O9l%<Bqz8fMm#{JWqMdoc_2N/|wf8]", "16:30:43.657 [scala-execution-context-global-67] DEBUG HelperUtils.Parameters$ - %iUGsT9u}ja^^b98Sp/BrP", "16:30:43.885 [scala-execution-context-global-67] WARN  HelperUtils.Parameters$ - 9G6>zk8%sDTYW2+CstxQ5a}#7\"dX\\[CVxHbcuR)dS{ucZBbCm9ASN/m+", "16:30:44.342 [scala-execution-context-global-67] INFO  HelperUtils.Parameters$ - J3]q]YdIQvtAC!r?g&a>nH=:-\"-pJ4", "16:30:44.663 [scala-execution-context-global-67] DEBUG HelperUtils.Parameters$ - [_%I2/|s1gC,U,\"?h_oSnA4{F1AXIgzUtbu\"y$|TCi;@", "16:30:44.951 [scala-execution-context-global-67] INFO  HelperUtils.Parameters$ - ?S=hW[iLQbhy_A/},i^oAC", "16:30:45.182 [scala-execution-context-global-67] INFO  HelperUtils.Parameters$ - c7B'p.rY#o\"GMbpRiSDTY7{<I'2k].k\"X8`66Uf=", "16:30:45.799 [scala-execution-context-global-67] INFO  HelperUtils.Parameters$ - Ja[.qxc^dHmz6q/xTM5eufHV5Iom`sKoY=|TDO[=XS", "16:30:46.350 [scala-execution-context-global-67] INFO  HelperUtils.Parameters$ - bd3e[IC2]otm>y-1BT=ZP*_pEP6mVNS0@XW*e7Iv.$<fzAFQ", "16:30:46.947 [scala-execution-context-global-67] WARN  HelperUtils.Parameters$ - bbD_[Fy_~pn\"Kjf/]Lp^-1", "16:30:47.015 [scala-execution-context-global-67] INFO  HelperUtils.Parameters$ - $1VkT2K*5qpF=>$4|-y!S.D<Ln9Fyu+#X'6-/:?>Kt,uEyu`", "16:30:47.718 [scala-execution-context-global-67] INFO  HelperUtils.Parameters$ - OFxB`e:k~34;]?W'&m`X]\"(q\"j\\pk`Ooac1\"Y7GN~`", "16:30:48.149 [scala-execution-context-global-67] WARN  HelperUtils.Parameters$ - UGmb8sla\"(jP>iq\"B^lohv599km_HrzaVY{)GM#&-8>hx&\\=", "16:30:48.366 [scala-execution-context-global-67] ERROR HelperUtils.Parameters$ - =\\sOJ7}t{}^TjQ%+8}`t.u,L?d", "16:30:48.470 [scala-execution-context-global-67] WARN  HelperUtils.Parameters$ - A\"KRC&Mr2uaR:{m*.W09Q)jR-FufK2`9%.ZaDB}J>YAPuuZu)P,]", "16:30:48.617 [scala-execution-context-global-67] WARN  HelperUtils.Parameters$ - =S#}axFBh#=g!5oSn9$qDu[HuX6S'a#U2&}mtzS]_d(w3R&g-G:/", "16:30:49.462 [scala-execution-context-global-67] INFO  HelperUtils.Parameters$ - dDf:EeEn%k|K\".&(fTp6Z_.LpF~Sq&ssQXf$F*0>", "16:30:50.236 [scala-execution-context-global-67] INFO  HelperUtils.Parameters$ - 0Vj=!O0yi4wmPZP@]%>kpn=f]{", "16:30:50.847 [scala-execution-context-global-67] INFO  HelperUtils.Parameters$ - {hNZM~u[bA:[`R.\\pEkMG)3U=qQrGih0T%Z%kij'e4QK3&(8xzy=Z)IgmI", "16:30:51.797 [scala-execution-context-global-67] WARN  HelperUtils.Parameters$ - `oYV'Lv=uSi$Q8}oa4ZVA&t4n5zjT.|*~:Q&gH(G!G4@}W3M", "16:30:52.415 [scala-execution-context-global-67] WARN  HelperUtils.Parameters$ - U|549qBJ+19v<bso_$dhpB]vtEbJw5oceY25*I'&?51afB{X", "16:30:53.418 [scala-execution-context-global-67] DEBUG HelperUtils.Parameters$ - |'2<c&qg-F?TZCYFz0Ugm!\\W)g0xEj#3VDo$$K[n`]*FW6hs-h"]

```
where the 3rd line of the code depicts the status code and the final line gives the body of the output received from the AWS lambda

In the GRPC client, a similar kind of output format is observed as shown below

```
17:48:20.412 [main] INFO  java.lang.Class - Status 200:["16:30:33.095 [run-main-0] WARN  HelperUtils.Parameters$ - Max count 100 is used to create records instead of timeouts", "16:30:33.748 [scala-execution-context-global-67] WARN  HelperUtils.Parameters$ - s%]s,+2k|D}K7b/XCwG&@7HDPR8z", "16:30:34.566 [scala-execution-context-global-67] INFO  HelperUtils.Parameters$ - ;kNI&V%v<c#eSDK@lPY(", "16:30:35.348 [scala-execution-context-global-67] INFO  HelperUtils.Parameters$ - l9]|92!uHUQ/IVcz~(;.Uz%K*5jTUd08", "16:30:35.669 [scala-execution-context-global-67] INFO  HelperUtils.Parameters$ - G3sw7^U<^q^Cl!aMTDbNz<:$;?e<.0JD_'", "16:30:36.500 [scala-execution-context-global-67] WARN  HelperUtils.Parameters$ - A><YFqpg+~\"E1T", "16:30:36.841 [scala-execution-context-global-67] DEBUG HelperUtils.Parameters$ - JrQB;P0\"&+6;&Dk-", "16:30:37.523 [scala-execution-context-global-67] INFO  HelperUtils.Parameters$ - OsI1`qAeU5H;\\+", "16:30:37.943 [scala-execution-context-global-67] INFO  HelperUtils.Parameters$ - [h!Q9PEY>L(NpKLBO\"Gjo:=4kRXQ_tZ!", "16:30:38.418 [scala-execution-context-global-67] INFO  HelperUtils.Parameters$ - B?y&C\"C5rsb:2037;f&|vM#x?z|Ny|&<44Z8B&rF1#&M", "16:30:38.702 [scala-execution-context-global-67] WARN  HelperUtils.Parameters$ - x2oBSI0/\\%CdfV2%ChSsnZ7vJo=2qJqZ%.\"kbc!0ne`y&m", "16:30:38.885 [scala-execution-context-global-67] ERROR HelperUtils.Parameters$ - ihu}!A2]*07}|,lc", "16:30:39.873 [scala-execution-context-global-67] INFO  HelperUtils.Parameters$ - CC]>~R#,^#0JWyESarZdETDcvk)Yk'I?", "16:30:40.102 [scala-execution-context-global-67] WARN  HelperUtils.Parameters$ - Swq;g+6M:?820=Gmd#.p)sFaqoKc^mm](.A8Z-4-].tp|cfR\\~rc(m^{", "16:30:40.980 [scala-execution-context-global-67] INFO  HelperUtils.Parameters$ - zXK=Fze%-6Iv-^q{zhG|EUzvd);tOj-:", "16:30:41.818 [scala-execution-context-global-67] INFO  HelperUtils.Parameters$ - ^<A>61@{3[KEk@M/Xh-q%sco3Dkwq~", "16:30:42.363 [scala-execution-context-global-67] WARN  HelperUtils.Parameters$ - Bv^B8Re'$VG)[P\".g*?f<G\\l5n.18B|i<E&rgPQZ;wBeA{4O/fy+Pp", "16:30:43.235 [scala-execution-context-global-67] WARN  HelperUtils.Parameters$ - k1H+R#/%d0>Q>N:6\\enT]U", "16:30:43.594 [scala-execution-context-global-67] INFO  HelperUtils.Parameters$ - 8G;,3m_T`G#H]&Yh:Ei1%fp''5`M8ube0J6vbf3bf3O9l%<Bqz8fMm#{JWqMdoc_2N/|wf8]", "16:30:43.657 [scala-execution-context-global-67] DEBUG HelperUtils.Parameters$ - %iUGsT9u}ja^^b98Sp/BrP", "16:30:43.885 [scala-execution-context-global-67] WARN  HelperUtils.Parameters$ - 9G6>zk8%sDTYW2+CstxQ5a}#7\"dX\\[CVxHbcuR)dS{ucZBbCm9ASN/m+", "16:30:44.342 [scala-execution-context-global-67] INFO  HelperUtils.Parameters$ - J3]q]YdIQvtAC!r?g&a>nH=:-\"-pJ4", "16:30:44.663 [scala-execution-context-global-67] DEBUG HelperUtils.Parameters$ - [_%I2/|s1gC,U,\"?h_oSnA4{F1AXIgzUtbu\"y$|TCi;@", "16:30:44.951 [scala-execution-context-global-67] INFO  HelperUtils.Parameters$ - ?S=hW[iLQbhy_A/},i^oAC", "16:30:45.182 [scala-execution-context-global-67] INFO  HelperUtils.Parameters$ - c7B'p.rY#o\"GMbpRiSDTY7{<I'2k].k\"X8`66Uf=", "16:30:45.799 [scala-execution-context-global-67] INFO  HelperUtils.Parameters$ - Ja[.qxc^dHmz6q/xTM5eufHV5Iom`sKoY=|TDO[=XS", "16:30:46.350 [scala-execution-context-global-67] INFO  HelperUtils.Parameters$ - bd3e[IC2]otm>y-1BT=ZP*_pEP6mVNS0@XW*e7Iv.$<fzAFQ", "16:30:46.947 [scala-execution-context-global-67] WARN  HelperUtils.Parameters$ - bbD_[Fy_~pn\"Kjf/]Lp^-1", "16:30:47.015 [scala-execution-context-global-67] INFO  HelperUtils.Parameters$ - $1VkT2K*5qpF=>$4|-y!S.D<Ln9Fyu+#X'6-/:?>Kt,uEyu`", "16:30:47.718 [scala-execution-context-global-67] INFO  HelperUtils.Parameters$ - OFxB`e:k~34;]?W'&m`X]\"(q\"j\\pk`Ooac1\"Y7GN~`", "16:30:48.149 [scala-execution-context-global-67] WARN  HelperUtils.Parameters$ - UGmb8sla\"(jP>iq\"B^lohv599km_HrzaVY{)GM#&-8>hx&\\=", "16:30:48.366 [scala-execution-context-global-67] ERROR HelperUtils.Parameters$ - =\\sOJ7}t{}^TjQ%+8}`t.u,L?d", "16:30:48.470 [scala-execution-context-global-67] WARN  HelperUtils.Parameters$ - A\"KRC&Mr2uaR:{m*.W09Q)jR-FufK2`9%.ZaDB}J>YAPuuZu)P,]", "16:30:48.617 [scala-execution-context-global-67] WARN  HelperUtils.Parameters$ - =S#}axFBh#=g!5oSn9$qDu[HuX6S'a#U2&}mtzS]_d(w3R&g-G:/", "16:30:49.462 [scala-execution-context-global-67] INFO  HelperUtils.Parameters$ - dDf:EeEn%k|K\".&(fTp6Z_.LpF~Sq&ssQXf$F*0>", "16:30:50.236 [scala-execution-context-global-67] INFO  HelperUtils.Parameters$ - 0Vj=!O0yi4wmPZP@]%>kpn=f]{", "16:30:50.847 [scala-execution-context-global-67] INFO  HelperUtils.Parameters$ - {hNZM~u[bA:[`R.\\pEkMG)3U=qQrGih0T%Z%kij'e4QK3&(8xzy=Z)IgmI", "16:30:51.797 [scala-execution-context-global-67] WARN  HelperUtils.Parameters$ - `oYV'Lv=uSi$Q8}oa4ZVA&t4n5zjT.|*~:Q&gH(G!G4@}W3M", "16:30:52.415 [scala-execution-context-global-67] WARN  HelperUtils.Parameters$ - U|549qBJ+19v<bso_$dhpB]vtEbJw5oceY25*I'&?51afB{X", "16:30:53.418 [scala-execution-context-global-67] DEBUG HelperUtils.Parameters$ - |'2<c&qg-F?TZCYFz0Ugm!\\W)g0xEj#3VDo$$K[n`]*FW6hs-h"]

```
Where the output line depicts status code followed by the body of the data received.

### To run the AWS environment
* Create a account in aws.amazon.com and create a IAM user.
* Create a S3 bucket.
* Create a EC2 instance to deploy the project
* Use the commands below to install required stack for the EC2 instance
```
chmod 400 scheru4.pem
ssh -i scheru4.pem ec2-user@3.134.81.148
sudo yum install git
sudo amazon-linux-extras enable corretto8
sudo yum clean metadata
sudo yum install -y java-1.8.0-amazon-corretto
```
* Deploy 'LogFileGenerator' in the EC2 instance
* Set Output path to S3 bucket created to store the logs
* Create a AWS lambda with python function.
* Create an API gateway as the Endpoint with a 'GET' request.
* Deploy the python code in LambdaExecuter/src/main/resources/lambda.py into the lambda function.
* Deploy the Lambda function
* Now the lambda function is ready for deployment.
* Youtube Link for explanation video is https://youtu.be/IOQO8BbiivE
