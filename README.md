# Java To-Do List Service for LAN

A modern Java + Spring Boot + JavaScript To-Do List application featuring priority sorting and a RESTful API.

## Features
* **Priority Sorting**: Tasks are marked as High, Medium, or Low and are automatically sorted by priority.
* **REST API**: Backend built with Java 25 and Spring Boot.
* **Modern UI**: Clean interface using Bootstrap and JavaScript Fetch API.
* **Persistent**: Uses H2 file-based database which stores files safely to remain intact after updates.

## Server Deployment
1. Clone the repo on your local machine
2. Package the project into an executable `.jar` file: `mvn clean package` (will appear in `/target/`)
3. Using SSH, WinSCP, FileZilla or any other service, get into your server
4. Create a directory for the app (e.g. todolist-app)
5. Transfer the .jar file into that directory
6. Create a service file so the service restarts in case of a server reboot or crash: `sudo nano /etc/systemd/system/todo.service`<br>
7. Copy and paste this into the file: (**change the `User` and `Working Directory` as needed**)<br>
   `[Unit]`<br>
   `Description=Java Todo List Service`<br>
   `After=network.target`<br>

   `[Service]`<br>
   `User=ubuntu`<br>
   `WorkingDirectory=/home/ubuntu`<br>
   `ExecStart=/usr/bin/java -jar /home/ubuntu/todo-list-0.0.1-SNAPSHOT.jar`<br>
   `SuccessExitStatus=143`<br>
   `Restart=always`<br>
   `RestartSec=10`<br>

   `[Install]`<br>
   `WantedBy=multi-user.target`<br>
8. Start/manage the service:<br>
   `sudo systemctl daemon-reload`<br>
   `sudo systemctl enable todo.service`<br>
   `sudo systemctl start todo.service`<br>
9. Finished!