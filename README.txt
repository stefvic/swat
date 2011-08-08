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
						
		5) ...

	Import project:
		1) Clone project from github
		2) Import maven project using m2eclispe plugin
TODO
