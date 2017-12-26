## Spring data jpa ##
- Java provides API for database operation using class-Object concept called Java Persitance API; It is a standard from oracle to perform ORM.
- JPA is part of EJB3 and Java EE.
- JPA comes with specification and API to perform Object and table relation
- ORM is a object relational maping; which is implementation of JPA specification
- example for ORM tools are Hibernate, OpenJPA, EclipseLink etc
- JPA API is set of classes like EntityManager, EntityManagerFactory and provide set of annotations to map java class and instance variable to table in database like @Entity, @Table, @Id, @Column etc
- Without spring data, we need to create a Data Access Object like EmployeeDao interface and it's implementation like EmployeeDaoImpl; which has to use EntityManager (if it's a jpa implementation) or HybernateTemplate (if it's a hybernation vendor) and EntityManagerFactory to perform database opearation. The EntityManagerFactory and EntityManager uses DataSource interface(which uses DriverManagerDataSource) to connect the database.
- Spring data jpa hides the boilerplate code; we no need to write DAO classes or interfaces; We need to define Class same like Table structure and give annotations like @Entity and @Id and create a interface which extends CRUDRepository to provide the basic sql operations as method
- Spring data also provides more functionalities like providing paging and sorting, finder methods etc.