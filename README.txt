API for finding NearestPhamracy:

Objective: When given input as co-ordinates of the customer i.e latitude and longitude, compute the nearest pharmacy location available.

Input: latitude and longitude of the customer

Output:
1)Name of the nearest pharmacy and address of the nearest phamracy
2)Distance between the input lantitude/longitude and the location of the phamracy

Prerequsities to run thi API:
1)Any Java IDE
2)MySQL database
3)sample data excel sheet

described detailedely in requirements.txt about how to run the program.


API behaviour and functionality:

Application.Java:

This is the main class from where the application gets up and running. It is annotated with @SpringBootApplication and @EnableSwagger2. A lot of boilerplate code is removed by configuring
the application with SpringBoot as we can remove a lot of configuration with respect to Spring Data and with this, we are readily available with embedded tomcat server to host.


Packages:

container:
PharmacyController:
Whenever,the API is hit, the request is delegated to the controller. I have annotated with @RestController and defined a method findNearestLocation which serves the api request and returns
the output.

entity:
2 entities are defined. They are
1)PhamracyDetails: In this entity, all the information which is available in sample data is created to map the data into a database. It is annotated with @Entity and zipcode is taken as
primary key for the table. Getters and setters are provided in this class.
2)NearestLocationDetails: In this entity, name, address and distance properties are defined and this entity is used to showcase the output.

repository:
PharmacyRepostiory: An interface is defined in repository package which extends from CrudRepository interface. All the implementation is provided by CrudRepository for the CRUD operations.
simply extending this interface would suffice for the given requirement.

service:
PharmacyService:In this interface, a method has been defined findNearestLocation with taking 2 parameters i.e latitude and longitude. This method will be called from controller layer in 
the method defined over there and passing the user inputs to the service interface method.

PharmacyServiceImplementation:
An implementation for the service interface is provided in this class. Entire logic of this API is available here. It is annotated with @service. Methods available in this class are

savePharmacyDetails():
This method is used to load the data available in csv sheet into database of our choice. sample csv sheet is stored in the classpath and a utility code for reading the data from csv sheet
is written in this method.

calculateDistance():
This method takes 4 input parameters, i.e 2 from user input cordinates and other 2 are from database cordinates. It computes the distance between them and returns the value to the function
whichever call this calculateDistance function.

findNearestLocation():
This is the actual implementation for the interface method which is overridden here. In this method,we call savePharmacyDetails() to load the data into DB and all the logic of finding the
bearest location for the given input latitude/longitude is written here.


exception:
LocationDetailsNotFoundException: This is an exception class which is decorated with a http error message whenever if there is an error in the function in which this exception is called.


API description:
The controller mehod is mapped with get request and request mapping syntax is "/api/findNearestLocation/{latitude}/{longitude}" where latitude and longitude should be replaced by user inputs.

Ouput:
It returns a payload i.e string which displays the name, address and distance of the computed pharmacy from the given cordinates.

How to run the program:
After installing all the softwares and packages(defined in the requirements.txt file), run the api in any browser or any api testing tool like postman in the below way

1)Run the main method of Application class. Once this is done with no errors, open any browser and request the api in below format 

http://localhost:8080/api/findNearestLocation/39.00142/-95.68695


