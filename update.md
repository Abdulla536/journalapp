date:11-2



&nbsp;	learnt about the 

&nbsp;		\*security like added the basic auth security to put(updata) the data with username \& password 

&nbsp;		\*basic details need to send through the basic auth and in the body with required updates like update username or password

&nbsp;		\*password is stored with bcyriped format so need to rember the pass



&nbsp;		\*every thing is done in the userdetailsserviceimp file 

date 12-2



&nbsp;	learn about the security with 

&nbsp;			\*the user can access only his jurnal entry with the credientials send form the auth 

&nbsp;			\* useing the name form the auth to get the details we use  ( Authentication authentication = 																	SecurityContextHolder.getContext().getAuthentication();

&nbsp;      												 String userName = authentication.getName();

&nbsp;		the about code stores the derails of the use and by using that we are getting the name and using that to get his details 



date:15-2

&nbsp;	

&nbsp;	learned about the put method (update the data) like "title and content" update and using the request like journal/id/id-num  with updated data 

&nbsp;	it must match the auth details and 

&nbsp;				



date:16-2



&nbsp;	learnd about the admin controller only the user who has the ROLE as ADMIN can access the admin commands 

&nbsp;	we have made a admin manually and used them as auth for creating other admins and accessing the data 

&nbsp;	the authonticmanager does all the roles finds for confromatoin and granting role 



date:22-2



&nbsp;	about testing using junit(java unit) to test individual testing of the each component (user for testing and edage cases)

&nbsp;	\* used the "assert" dependency and used the assertEquals and assertNotNull methods for testing

&nbsp;	\* used the @springBootTest annotation to automatically stats the code and starts the test too and test provides output as "0" for found and -1 for 	not found 

&nbsp;	

&nbsp;	\* for testing the components no need to intrect with the data base which(takes times because of db intrection ) which is not required for testing 

&nbsp;	 to avoid that db intrectoin and faster testing with stating hole project we can use **"MOCKITO"

	"MOCKITO" it avoids hitting db and uses MOCK**  dependency ,avoid calling real server 

