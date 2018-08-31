# <i><b>FoodTruckApp</b></i>

The Food Truck App is a simple command line application that allows you to see what food trucks are open at the current time and day of running the application. The application will only display 10 food trucks at a time and will prompt you to see more food trucks that are currently open. If there are no current open Food Trucks, the program will exit, not displaying anything.



<i><b>Adding Dependencies</b></i>

There is no need to install any dependencies to run the application as you will be using the command terminal to execute a runnable .jar file (Java Archive File) which includes all of the necessary dependencies. If you wish clone or download the source files, you will see two dependencies added to the pom.xml file located at this link (https://github.com/aaronaguil/FoodTruckApp/tree/master/FoodTruck) as they are currently being used in the application for parsing JSON. If you decide to expand on this application and require more external libraries, the pom.xml is where you will be adding your dependencies. You may also add external .jar files to your class path.



<i><b>Importing the project into Eclipse</b></i>

If you decide you want to expand on this application, please download the FoodTruckApp.zip file at the root of the repository. This .zip file contains the .jar file for running the application as well as all of the source files. If you are using Eclipse as an IDE, you can import the Food Truck App folder located in the .zip file to import the Food Truck project.

To do this, first open eclipse.

Click on the <i>File</i> tab at the top, then click on <i>import</i>

This will open a popup window. Click on <i>General,</i> then click on <i>Import existing projects into workspace.</i>

Click on <i>Browse</i>  next to <i>root directory</i> and locate the Food Truck app in your <i>Downloads</i> directory.

Select <i>FoodTruck,</i> and click <i>Finish.</i>

You should now have imported the Food Truck project into eclipse.



<i><b>Running the application from the command line (Mac OS X)</b></i>

To run this application, go to this link (https://github.com/aaronaguil/FoodTruckApp/blob/master/FoodTruckApp.jar) and click on the download button (green button on the right hand side). This will download the .jar file that is necessary to run the application. Once you have downloaded the .jar file, open up the terminal window on your computer (click on the search icon on the top right hand corner of the screen and type “terminal”. Then press enter).

Once you are in the terminal window, the search for the .jar file in your downloads directory.

Type the command:

<i>cd Downloads</i>

this will bring you to the “Downloads directory”

then type:

<i>java -jar FoodTruckApp.jar</i>

this should allow you to run the application.



<i><b>Full Scale Web Application</b></i>

Although this is a command line application, I built this application as a maven project. If this were a full scale web based application, I might still build it as a maven project. However, I would also have other configuration files that would allow me to configure things like what html/jsp files to point to upon running the application or where to route the requests made from a user. Requests might even route to a different application. Currently, the command application takes user input and just continues to run the same application.

There wouldn’t be a main method in the FoodTruckFinder.java file. Different views (GUI) would be rendered and user input would be received through those views rather than the terminal. The config file would then know where to route the requests within the application. I would most likely keep the service and data access object (DAO) but a controller would take the place of the FoodTruckFinder.java file. That controller would take requests and interact with the food truck service, which would have access to the DAO to retrieve the data necessary. I would also store the list of open restaurants in the session so that it is not stores as a field variable in the DAO. The FoodTruckFinder also wouldn’t have to have methods to display information or format display information. That can be done on the client side.

There are many more things that would be different if this were a full scale web application. I encourage you to expand on this application and let your creativity take over. I look forward to see what you come up with!
