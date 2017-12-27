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

### CRUD Operation ###
- Steps to do crud operations
	- Create Entity or modle(simple POJO) class
	- Create Crud repository interface
	- Configure the Data Source/Data base connection configuration
- Create Entity class similar to table and annotate @Entity, @Table, @Id and @Column
- Create an interface which extends CrudRepository<T, ID extends Serializable>; the crud repository provides basic operations to repository object
- add database configuration settings in application.properties file
[ref](https://github.com/dvinay/spring-jpa-crash-course/commit/7db210d4ceadfae8da909d48d2d65aea95c15088)
