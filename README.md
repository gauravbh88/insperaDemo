# insperaDemo

# Prequisite

1. Docker should be installed on the machine and docker desktop should be running on machine.
2. Maven should be installed on the machine.

# Steps to run the test.

1. Clone the project to your local machine.
2. Open command prompt and navigate to project folder.
3. To spin up all the conatiners run command:

                a. docker-compose up
                
4. Once all the selenium hub and nodes containers are up you can run the test.
5. To run the test, Run below commands on a seperate command promt window after navigating to project folder:
                
                a. mvn clean
                b. mvn test
                
6. To see what is happening inside containers we need to use vnc viewer , To connect to VNC veiwer we need to know ports on which different containers are running
   we can get the port information by running docker ps -a in a separate command prompt.
   
7. Once the test is over , to bring down the containers run command : 

                a. docker-compose down   
               
