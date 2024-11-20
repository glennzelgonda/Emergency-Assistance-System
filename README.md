![paspas1](https://github.com/user-attachments/assets/e85d75d2-7430-45a7-a041-1ac6f31f06fd)

I. **PROJECT OVERVIEW**
     
PASPAS: Emergency Response System is a Java-based application, specifically designed to provide crucial support to individuals amid emergencies. This system connects users to important resources with remarkable speed and efficiency. It empowers users to report a wide array of emergencies, including natural disasters like floods and earthquakes, urgent incidents, fiery blazes, and criminal activities. When users report an emergency, they are promted to provide essential details, such as their name, exact location, and comprehensive description of the situation at hand.    
     
In today's world, especially in our country Philippines, we are experiencing severe calamities, disasters, and crimes or tragedies that cause panic and fear among people. PASPAS is built to address this pressing issue by offering quick assistance during such stressfull moments. This system is created to lessen the stress and confusion often associated with seeking help in crises, particularly for individuals who may be feling panicked or unsure about where to turn for assistance. It effectively addresses commmon challenge of not knowing which emergency hotline to dial, streamlining their path to receiving the help they need without unnecessary delays. 

PASPAS goes beyond just reporting emergencies; ut stimulates response procedures. This includes tarcking the user's location in real-time and confirming the raoid deployment of assistance to their location. With its intuitive and user-friendly indterface, along with a highly effective workflow, PASPAS aims to ensure that emergency reporting is accessible to everyone, thereby guaranteeing swift and reliable help during the most critical times.

II. **APPLICATION OF OBJECT-ORIENTED PROGRAMMING (OOP)**

The PASPAS Emergency Assistance System utilizes the core Object-Oriented Programming (OOP) principles—Encapsulation, Inheritance, Abstraction, and Polymorphism—to create a structured, maintainable, and scalable application that efficiently handles various emergency scenarios.

 -> **Encapsulation**

Encapsulation is used to bundle the system's data (attributes like name, location, emergency type) and the methods (functions like handling emergencies) together within classes. This approach hides the internal complexities of the system from external components, which improves the maintainability and security of the system. For example, the Emergency class encapsulates the common properties of all emergency types, providing methods to interact with them, while subclasses like FloodEmergency or FireEmergency handle specific behaviors.

 -> **Inheritance**

Inheritance allows subclasses to inherit attributes and methods from a parent class, making the system flexible and reducing code duplication. The Emergency class acts as the base class, and all specific emergency types (such as FloodEmergency, FireEmergency, EarthquakeEmergency, MedicalEmergency, and CrimeEmergency) inherit its attributes and methods. Each subclass can then extend or override the inherited methods to implement behavior specific to the emergency type.

-> **Abstraction**

Abstraction simplifies the interface and hides the complex logic of handling different types of emergencies. The Emergency class defines an abstract handleEmergency() method, which each subclass implements according to the specifics of the emergency. This allows the system to interact with all emergencies using a uniform interface, without needing to understand the details of each emergency type.

-> **Polymorphism**

Polymorphism enables the same method to behave differently depending on the object that calls it. This allows the system to handle various emergency types in a uniform way, while still providing specialized behavior for each type. When the user selects an emergency type (example: "Flood"), the system creates an instance of the corresponding subclass (FloodEmergency) and calls the appropriate handleEmergency() method. This behavior is determined dynamically at runtime, simplifying emergency handling.


 **FILE DESCRIPTION**
 
 -> Emergency.java
This is the base class that establishes the common structure for all emergency types. It contains shared attributes such as the user's name and location. Additionally, it defines two abstract methods:

handleEmergency(): This method is implemented by subclasses to provide customized responses for each specific emergency type.

reminder(): This method offers tailored reminders or safety precautions relevant to the emergency type.

The Emergency.java class ensures that all emergency types follow a consistent structure while allowing each subclass to implement specific behavior for their type of emergency.

-> Subclasses (CrimeEmergency.java, FireEmergency.java, FloodEmergency.java, MedicalEmergency.java, EarthquakeEmergency.java)
     These subclasses extend the Emergency class, each representing a distinct type of emergency. Below is an overview of what each subclass does:
     
* CrimeEmergency.java: Handles crime-related emergencies (e.g., theft or assault).
-Implements the handleEmergency() method to simulate notifying law enforcement.
 Provides safety reminders, such as staying calm and avoiding confrontation.

* FireEmergency.java: Manages fire-related situations.
     Simulates connecting the user to the fire department and provides fire safety instructions.
     Offers reminders on how to stay safe during a fire, such as evacuating and avoiding smoke inhalation.
     
*FloodEmergency.java: Handles flood-related emergencies.
     Provides reminders like seeking higher ground and avoiding floodwaters.
     Implements flood-specific safety messages and actions.
     
*MedicalEmergency.java: Focuses on medical emergencies (e.g., accidents, heart attacks).
     Provides calming messages and emphasizes the need to give responders clear and concise information.
     Offers tips on how to assist medical responders upon arrival.
     
*EarthquakeEmergency.java: Manages earthquake-related emergencies.
     Includes reminders about techniques like drop, cover, and hold.
     Advises users to stay away from windows and unsafe structures during and after an earthquake.
     Each subclass ensures that users receive relevant, emergency-specific guidance, enhancing both the system’s realism and usability.
     
->EmergencyGUI.java
     This file contains the graphical user interface (GUI) for the PASPAS system, handling user interactions and integrating the emergency classes' functionality.
     Key Components:
     
Input Fields:
     nameField: A text field for users to input their name.
     locationField: A text field for users to enter their location.
     additionalInfoArea: A text area for users to provide additional emergency details (optional).
     Emergency Type Dropdown:
     This dropdown allows users to select the type of emergency (e.g., "Flood", "Crime").
    
Buttons:
     Submit: Validates the input fields, processes the emergency, and displays corresponding responses.
     Clear: Resets all input fields and response areas.
     Response Areas:
     resultArea: Displays confirmation messages and estimated response times.
     reminderArea: Shows emergency-specific reminders or safety tips.
     
Workflow in EmergencyGUI.java:
     -> User Input Validation:
     If the name or location fields are empty, an error message prompts the user to fill in the necessary information:
     "Please enter your name to assist you."
     "Please enter your location to assist you."
     If both fields are empty: "Please enter your name and location to assist you."
     Emergency Type Selection:
     The system ensures the user selects a valid emergency type. If none is chosen, an error prompts the user to select a valid emergency type.
     
->Dynamic Emergency Handling:
     Based on the emergency type selected, an instance of the corresponding subclass (e.g., CrimeEmergency) is created. The system then invokes the handleEmergency() and reminder() methods for that specific emergency type, displaying relevant responses and safety tips. 
     
->Simulated Processing:
     A timer simulates the progression of steps, such as:
     "Confirming details..."
     "Tracking location..."
     "Location confirmed. Help is on the way."
     
->Display Results:
     The result areas show emergency-specific responses, reminders, and additional details entered by the user, ensuring the user receives timely and helpful information during the emergency.

 Imports in EmergencyGUI.java
     In the EmergencyGUI.java file, several Java packages are imported to facilitate the functionality of the user interface. Below is a description of the main imports used in this file:

 -> import javax.swing.*;
     This import is used to include all the components necessary for building the graphical user interface (GUI). The javax.swing.* package provides classes like JFrame, JButton, JTextField, JLabel, JComboBox, etc., which are essential for creating windows, buttons, text fields, and other UI components in the application. Key components like the JFrame (the main window), JButton (for user actions like submitting or clearing inputs), and JTextField (for input fields) are part of this package.
     
-> import java.awt.event.ActionListener;
     The ActionListener interface is imported to handle user interactions with buttons. It allows the program to execute specific actions when a user clicks a button, such as submitting emergency details or clearing the form. This interface is used in conjunction with the addActionListener() method to define what happens when a button is clicked.
     
-> import java.awt.event.ActionEvent;
     This class is used to represent an action event, which occurs when a user interacts with a component like a button. The ActionEvent object holds information about the action performed (e.g., which button was clicked) and is passed to the actionPerformed() method of the ActionListener to trigger the desired action.
     
-> import java.awt.*;
     The java.awt.* package is used to provide additional functionality for layout management and graphics. It includes classes such as Font, Color, and GridLayout. For example, the Font class is used to set the font style and size for labels and buttons in the GUI, while the GridLayout class helps arrange the components in a grid-based layout.
     
-> import javax.swing.border.EmptyBorder;
     This import allows the program to add custom borders to GUI components like text fields and buttons. The EmptyBorder class is used to create spacing around components, improving the overall look and usability of the interface.

III. Alignment with Sustainable Development Goals (SDGs)
The PASPAS system supports SDG 11, which aims to create sustainable and safe cities. It specifically helps improve disaster response and community resilience in the following ways:

1. Improving Emergency Response
     PASPAS enhances emergency response times by making it easier to report emergencies. When disasters occur, every second counts. PASPAS provides a straightforward interface that helps users select the type of emergency and enter their name, location, and details. This structured approach captures essential information quickly, ensuring that help is dispatched promptly. By automating the reporting process, the system reduces delays and errors that can happen with manual calls.
     
2. Enhancing Disaster Resilience
     PASPAS helps communities prepare for disasters, whether from nature or human causes. It provides specific reminders on how to act during emergencies. For example, it advises users to find higher ground during floods or to evacuate safely in case of a fire. This readiness helps save lives and lessen the impact of disasters by ensuring that help arrives quickly.
     
3. Promoting Inclusivity
     A major challenge in emergencies is making sure everyone can access help, regardless of their background or tech skills. PASPAS is designed to be simple and user-friendly, allowing anyone to navigate it easily. This inclusive approach ensures that more people can request assistance during critical times, particularly in areas where emergency services might be harder to reach. By breaking down barriers, PASPAS empowers individuals to act quickly when they need help.

IV. INSTRUCTION FOR RUNNING THE PROGRAM
1. Download the Project: Clone or download the PASPAS files.
     
2. Install Java: Ensure that Java is installed on your machine. The system is developed using Java, so you need a Java Development Kit (JDK) installed.
    
3. Set Up the Project:
     Open the PASPAS folder in your preferred Integrated Development Environment (IDE) such as Eclipse, IntelliJ IDEA, or Visual Studio Code.
     Make sure the Java files are properly imported and recognized by your IDE.

4.Compile the Program:
     Compile the Java files to check for any errors. Most IDEs will automatically do this for you when opening the project.
     
5.Run the Program:
     In your IDE, run the EmergencyGUI.java file. This is the main user interface that will open when the program is executed.
     The GUI will prompt the user to select an emergency type, enter their name, location, and additional information, and simulate an emergency response.
     
6.Interacting with the Program:
     Select the type of emergency from the dropdown menu (e.g., Fire, Crime, Flood, etc.).
     Enter your name, location, and any additional information.
     Click "Submit" to trigger the emergency response.
     The system will simulate tracking the user's location and provide emergency-specific reminders.

