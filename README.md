# Network of Giving (VMware TalentBoost 2020 Final task)
Network of Giving is a CRUD application that can be accessed by multiple users. Every registered user can create, delete, update and read charities.
You can also donate money for particular charity and became a volunteer. I have used PostgreSQL to store my data, Spring Boot for my back-end and Angular for front-end.
Following steps describe basic functionallity of the app:

    - CREATE - When the user inputs title, image, description, volunteers required and donations required and clicks on button CREATE, a function "createCharity()" is called to send POST request to backend and create an object.

    - DELETE - When a user want to delete a charity, he/she clicks on a button and after that a function "deleteCharity(id: number)" is called and a DELETE request is send to the back-end.

    - UPDATE (EDIT) - When the user inputs title, image, description, volunteers required and donations required and clicks on button CREATE, a function "editCharity()" is called to send PUT request to backend and create an object.

    - READ - On the home page all charities created by users are presented by calling a function "loadData()", which makes a GET request to the database. Also when you click on charity you can see all charity details.

    - SEARCH - To realize this functionality, I have used Angular Filter, which enables to find a charity by title.

    - DONATE - When you click on button "DONATE" in Charity details page, every registered user can donate money. This functionality is realized through а function 
    "editCharityDonation()" in Charity details Component.

    - VOLUNTEER - When you click on button "VOLUNTEER" in Charity details page, every registered user can became a volunteer. This functionality is realized through а function "editCharityVolunteers()" in Charity details Component.

    - UPLOAD IMAGE - When a user created or edits a charity he/she could upload a picture to represent the charity. (images.fs.directory - system property for the directory in which the back-end will save images. The format is: images.fs.directory=C:\Users\Terry\network-of-giving-images; 
    static.images.file.path - system property for the filesystem path that should be served under /images (should be the same directory as above but in a different format). The format is: static.imagesfilepath=file:///C:/Users/Terry/network-of-giving-images/)

    - REGISTRATION AND LOGIN - Once the user is already registered (which is implemented in a similar way to crate charity), he/she could login. After that every subsequent request includes the JWT, allowing the user to access create charity, edit charity and other functionalities that he/she is not allowed to access in    other situation.