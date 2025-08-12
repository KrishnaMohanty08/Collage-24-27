#include <sys/types.h>          
#include <sys/socket.h>
#include <stdio.h>
#include <netinet/in.h>
#include <netinet/ip.h>
#include <arpa/inet.h>
#include <string.h>

int main(){
	int sockfd=socket(AF_INET,SOCK_DGRAM,0);
	if(sockfd==-1)
		printf("socket not created\n");
	else
		printf("Socket created\n");
		
	//bind
	struct sockaddr_in server_addr,client_addr;
	
        server_addr.sin_family=AF_INET;
        server_addr.sin_port=htons(5017);
        server_addr.sin_addr.s_addr=inet_addr("127.0.0.1");
        
        int bind1=bind(sockfd,(const struct sockaddr*)(&server_addr),sizeof(server_addr));
    if(bind1==-1)
		printf("bind failed\n");
	else 
		printf("bind success\n");
		
	//Receive message at server site
	
	char charBuffer[100];
	int flags=0,temp=sizeof(client_addr);
	
	client_addr.sin_family=AF_INET;
      	client_addr.sin_port=htons(5017);
        client_addr.sin_addr.s_addr=inet_addr("127.0.0.1");
        
	int rvc=recvfrom(sockfd,charBuffer,sizeof(charBuffer),flags,(struct sockaddr*)(&client_addr),&temp);
	if(rvc==-1){
		printf("Receiver Error!\n");
		return 1;
		}
		printf("Message Received %s\n",charBuffer);
	
	
	return 0;
}


