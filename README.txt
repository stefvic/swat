###############################################################################
For developer purpose:
	List of tools used :
		1) JDK 1.6
		2) Maven 3.x
		3) Eclipse (3.7 "Indigo")
			
			-- Code Style : /ext/codestyle/eclipse/java_conventions_style.xml
				Use Window/Preferences, Java/Code Style/Formatter, press import ...
				
			-- m2eclipse plugin : 
				1) Use Help/Eclipse Marketplace (search : m2eclipse, install)
				   or
				2) Use Help/Install New Software, Add : http://download.eclipse.org/technology/m2e/releases
				   (preferd)
									  
			-- Egit plugin :
				1) Use Help/Eclipse Marketplace (search : egit, install)
					or
				2) Use Help/Install New Software, Add : http://download.eclipse.org/egit/updates
		
		4) Configuration JPA model generation :
			- use this link 
				http://docs.jboss.org/hibernate/stable/jpamodelgen/reference/en-US/html/chapter-usage.html#maven-dependency
				(2.2.2 for eclispe IDE)
				custom rules: 
					generated source directory: target/generated-sources/apt (maven like)
					add in jars in factory path: 
						hibernate-jpamodelgen-1.1.1.Final.jar
						hibernate-jpa-2.0-api-1.0.1.Final.jar
						
		5) Instead of using Criteria API, we use (at least will try to use) Query DSL - which is the same type safe query builders, but made much easier with Query DSL.
		   More about : http://blog.mysema.com/2010/07/querying-hibernate-with-querydsl.html
		   				http://blog.springsource.com/2011/04/26/advanced-spring-data-jpa-specifications-and-querydsl/

	Import project:
		1) Clone project from github
		2) Import maven project using m2eclispe plugin
		
		
		
PERSIST is create new records from object in the database.
DELETE  is, well, delete.
MERGE, for existing objects, to merge the existing data in the table with the data in my object. (sync to database)
REFRESH is to refresh the data in the object. Perhaps there was a change on the database which needs to be synced. (sync from database)
			
TODO
