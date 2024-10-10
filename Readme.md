📄 Description - Project Statement

This project consists of developing an API for a web application that manages users and events. It makes possible resgistration of users, the management of the events data and the import/export of such events in JSON format.
The project is document with Swagger.

💻 Technologies Used

    - Java
    - Spring Boot
    - MongoDB
    - Reactive programming with Project Reactor
    - Maven
    - Swagger


📋 Requirements

    - Java 21 or higher
    - Maven 3.9.9 or higher
    - MongoDB v4.4+
    - Spring Boot v2.6+
    - Internet connection for dependency downloading


🛠️ Installation

    1. Clone this repository:

      git clone https://github.com/mikedukakis/hackato.git

    2. Navigate to the project directory:

      cd hackato

    3. Install dependencies using Maven:

      mvn clean install

    4. Configure the application:
        - Update your MongoDB connection details in application.properties under the src/main/resources directory.

▶️ Execution

    1. Make sure MongoDB is running on your local machine or on a configured server.
    
    2. Start the application:

      mvn spring-boot:run

    3.  The application will be available at http://localhost:8080

🌐 Deployment

    1.  Prepare the production environment.
    
    2.  Upload the project files to the production server.
    
    3.  Configure the server to point to the production database for MongoDB.
    
    4.  Ensure environment variables are properly set for MongoDB configuration.
    
    5.  Check the Swagger documentation on http://localhost:8080/webjars/swagger-ui/index.html#/
    

🤝 Contributions

Contributions are welcome! Please follow the steps below to contribute:

    1.  Fork the repository.
    
    2.  Create a new branch:

      git checkout -b feature/NewFeature

    3.  Make your changes and commit them:

      git commit -m 'Add New Feature'

    4.  Push the changes to your branch:

      git push origin feature/NewFeature

    5.  Create a pull request.