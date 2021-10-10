# Getting Started  
Date: Oct-10-2021  
  
# Signup for google cloud platform account with your gmail   
https://console.cloud.google.com/  

1. Setup pubsub  
https://console.cloud.google.com/cloudpubsub  
  
2. Create topic "topic-one"  
  
3. Create subscription "topic-one-sub"  
  
4. Create service account with access as owner for now  
How to generate service account key?  
https://m2msupport.net/m2msupport/generate-service-account-key-in-google-cloud-platform-gcp/ 
  
5. Download JSON.key file  
  
6. Using base64 or any tool, encode the json.key. In final key, remove new lines  
  
7. Update topic id and key in application.properties file  
      
# Run the Example    
  
>mvn install  
  
>java -jar target/pubsub-example-0.0.1-SNAPSHOT.jar  
  
Try this  
http://localhost:8080/greeting?name=message1  
  
Use this URL to see the messages  
https://console.cloud.google.com/cloudpubsub/subscription/detail/topic-one-sub?project=alert-palace-328614&tab=messages  
  
# Reference  
Add this to .m2/settings.xml file
https://repo.spring.io/ui/packages  

<repository>  
    <id>spring-milestone</id>  
    <name>Spring Milestone Repository</name>  
    <url>https://repo.spring.io/milestone</url>  
</repository>  
  
GCP PubSub Example  
https://spring.io/guides/gs/messaging-gcp-pubsub/  
  
GCP Variables  
https://docs.spring.io/spring-cloud-gcp/docs/1.1.0.M1/reference/html/spring-cloud-gcp-core.html 
  
Rest Service  
https://spring.io/guides/gs/rest-service/  

-o-