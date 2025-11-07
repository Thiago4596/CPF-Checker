# CPF Checker 🇧🇷

A simple Spring Boot application for validating and formatting Brazilian CPF numbers. This project provides a set of utility functions to check the validity of a CPF, format it into the standard format, and determine the associated Brazilian state. It's designed to be easily integrated into other applications requiring CPF validation.

🚀 **Key Features**

*   **CPF Validation:** Determines if a given CPF number is valid according to the Brazilian standard.
*   **CPF Formatting:** Formats a CPF number into the standard `XXX.XXX.XXX-XX` format.
*   **State Determination:** Identifies the Brazilian state associated with a CPF based on its 9th digit.
*   **Simple API:** Easy-to-use methods for validation, formatting, and state determination.
*   **Console Input:** Accepts CPF input directly from the console for testing and demonstration.

🛠️ **Tech Stack**

*   **Backend:** Java
*   **Framework:** Spring Boot
*   **Build Tool:** Maven
*   **Utilities:**
    *   `java.util.Scanner`
    *   `com.google.code.gson:gson`
    *   `io.github.cdimascio:dotenv-java`
*   **Testing:** `org.springframework.boot:spring-boot-starter-test`

📦 **Getting Started**

### Prerequisites

*   Java Development Kit (JDK) 8 or higher
*   Maven
*   An IDE (e.g., IntelliJ IDEA, Eclipse) is recommended but not required

### Installation

1.  **Clone the repository:**

    ```bash
    git clone <repository_url>
    cd <repository_directory>
    ```

2.  **Build the project using Maven:**

    ```bash
    mvn clean install
    ```

### Running Locally

1.  **Navigate to the project's root directory.**
2.  **Run the Spring Boot application:**

    ```bash
    mvn spring-boot:run
    ```

    Alternatively, you can run the `MainApplication.java` file directly from your IDE.

3.  **Interact with the application:** The application will prompt you to enter a CPF number in the console. Enter a CPF number and press Enter. The application will validate the CPF and print the result to the console. To exit, type "sair" and press Enter.

💻 **Usage**

The `CpfConsult` class provides the main entry point for interacting with the CPF validation functionality.  It takes a CPF number as input, validates it using the `CpfValidador` service, and prints the result to the console.

Example interaction (via console):

```
Enter a CPF number (or 'sair' to exit): 12345678900
CPF is invalid: 12345678900

Enter a CPF number (or 'sair' to exit): 14725836914
CPF is valid: 147.258.369-14

Enter a CPF number (or 'sair' to exit): sair
```

📂 **Project Structure**

```
cpf-checker/
├── main/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   ├── com/
│   │   │   │   │   ├── cpfChecker/
│   │   │   │   │   │   ├── main/
│   │   │   │   │   │   │   ├── MainApplication.java
│   │   │   │   │   │   │   ├── models/
│   │   │   │   │   │   │   │   ├── CpfConsult.java
│   │   │   │   │   │   │   ├── services/
│   │   │   │   │   │   │   │   ├── CpfEstado.java
│   │   │   │   │   │   │   │   ├── CpfValidador.java
│   │   │   │   │   │   │   │   ├── JsonCapture.java
│   ├── resources/
│   │   │   │   │   │   │   │   ├── application.properties
│   ├── pom.xml
```

📸 **Screenshots**

(Add screenshots of the application in action here)

🤝 **Contributing**

Contributions are welcome! Please feel free to submit pull requests with bug fixes, new features, or improvements to the documentation.

📝 **License**

This project is licensed under the [MIT License](LICENSE).

📬 **Contact**

If you have any questions or suggestions, please feel free to contact me at [your_email@example.com](mailto:your_email@example.com).

💖 **Thanks**

Thank you for checking out this project! I hope it's helpful for your CPF validation needs.

This is written by [readme.ai](https://readme-generator-phi.vercel.app/)
