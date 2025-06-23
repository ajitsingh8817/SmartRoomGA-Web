# SmartRoomGA-Web
SmartRoomGA is a Spring Boot Web Application that uses a Genetic Algorithm (GA) to smartly allocate students to their preferred rooms based on their preferences and eligibility.  This project solves the real-life problem of optimal room allocation using evolutionary techniques.
🚀 Features
📋 Input student preferences and room details from the UI.

🧬 Genetic Algorithm based intelligent allocation.

⚡ Fast and simple web interface using Thymeleaf.

💻 Easy to run on localhost:8080.

🛠️ Tech Stack
Java 17

Spring Boot

Maven

Thymeleaf (for frontend)

Genetic Algorithm (custom implementation)

📂 Project Structure
css
Copy
Edit
SmartRoomGA-Web
├── src/main/java/com/example/smartroomga
│   ├── SmartRoomGaApplication.java
│   ├── controller/RoomGAController.java
│   └── model/
│       ├── Student.java
│       └── Room.java
├── src/main/resources/templates/
│   ├── index.html
│   └── result.html
├── src/main/resources/application.properties
└── pom.xml
🔧 How to Run
Clone the repository:

bash
Copy
Edit
git clone https://github.com/your-username/SmartRoomGA-Web.git
Move to the project directory:

bash
Copy
Edit
cd SmartRoomGA-Web
Run the project:

bash
Copy
Edit
mvn spring-boot:run
Open your browser:

arduino
Copy
Edit
http://localhost:8080
📌 Inputs
Student Preferences: Single/Double Room

Year: Year of study

Room Types: Single/Double

AC Preference: True/False

🎯 Output
Optimized room allocation using Genetic Algorithm.

Displays student-to-room mapping on the result page.

🙏 Acknowledgements
Made with by Ajit singh project.
