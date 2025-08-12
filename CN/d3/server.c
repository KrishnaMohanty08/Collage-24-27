#include <sys/types.h>          
#include <sys/socket.h>
#include <stdio.h>
#include <netinet/in.h>
#include <netinet/ip.h>
#include <arpa/inet.h>

int main(int argc,char  *argv[]){
	int sockfd=socket(AF_INET,SOCK_DGRAM,0);
	if(sockfd==-1)
		printf("socket not created\n");
	else
		printf("Socket created\n");
		
	//bind
	//struct sockaddr_in is a special structure defined in <netinet/in.h> for IPv4 addresses.
	struct sockaddr_in myaddr;

	// sin_family tells the socket API what kind of address this is.--AF_INET = Address Family for IPv4.
	// sin_port is the port number where the server will listen or send.
	// Important: Ports in networking are stored in network byte order (big-endian).
	// htons() = Host TO Network Short — converts your system’s native byte order to network order.
	// SERVER_PORT here might be 5017, so after conversion it’s stored in the correct format.
	
        myaddr.sin_family=AF_INET;
        myaddr.sin_port=(int )htons(atoi(argv[1]));
        myaddr.sin_addr.s_addr=inet_addr(argv[2]);
        
        int bind1=bind(sockfd,(const struct sockaddr*)(&myaddr),sizeof(myaddr));
        if(bind1==-1)
		printf("bind failed\n");
	else 
		printf("bind success\n");
	return 0;
}

