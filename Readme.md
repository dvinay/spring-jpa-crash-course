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
- Create an interface which extends CrudRepository<T, ID extends Serializable>; the crud repository provides basic operations to repository object like create, findOne, findAll, count, save, delete, exist
- add database configuration settings in application.properties file
[ref](https://github.com/dvinay/spring-jpa-crash-course/commit/7db210d4ceadfae8da909d48d2d65aea95c15088	)
- Note: spring JPA doesn't show the query while running the code; you can enable to display the query by adding spring.jpa.show-sql=true in application.properties

### ID Generators ###
- When Id as primary key to select the unique row in datbase table; the primary key is depending on the table configuration.
- JPA provides the generation of Id in 4 different ways
	- GenerationType.AUTO
	- GenerationType.IDENTITY
	- GenerationType.SEQUENCE
	- GenerationType.TABLE
- To configure the above id strategy; we need to add the @GeneratedValue(strategy=GenerationType.AUTO) annotation with generation type
- for AUTO; the JPA provider checks the database what kind of strategy does the database supports identity or sequence or table
- for IDENTITY; the primary key is a auto increment; database will automatically increment for us.
- for SEQUENCE; the primary key uses custom logic for sequence to generate
- Note: mysql don't supports sequences
- for TABLE; persistence provider uses a special table to store the keys and uses that keys as primary key for table; we need to create special table along with entity table

- To use IDENTITY; the table must contain primary key as auto increment like
- create table employee( id int PRIMARY KEY AUTO_INCREMENT, name varchar(20))
- the entity must have @GeneratedValue(strategy=GenerationType.IDENTITY)
[ref](https://github.com/dvinay/spring-jpa-crash-course/commit/0503d7644c747ee0371bd5e16453cfb9a701af89)

- To use TABLE; we have to create a special table/placeholder for to keep the id
```SQL
-- data table
create table employee(
id int PRIMARY KEY,
name varchar(20)
)
-- special table
create table id_gen(
gen_name varchar(60) PRIMARY KEY,
gen_val int(20)
)
```
- here; gen_val is the value generated by hibernate
- to use table generator we need to give the placeholder table name, primary key and value info as annotation @TableGenerator(name="employee_gen", table="id_gen", pkColumnName="gen_name",valueColumnName="gen_val",allocationSize=100)
- we have to map the table in @GeneratedValue like @GeneratedValue(strategy=GenerationType.TABLE, generator="employee_gen")
[ref](https://github.com/dvinay/spring-jpa-crash-course/commit/a8e338bbb0e1f2decc720d668233b10930d896c2)

- Instead of JPA provider Generater strategy, we can develop our own custom strategy; the custom strategy must develop a unique value
	- create a class which implements hibernate IdentifierGenerator
	- overide generate method with custom unique id generation logic
	- to use custom generator using @GenericGenerator and @GeneratedValue 
[ref](https://github.com/dvinay/spring-jpa-crash-course/commit/d1f6d473c794a29386b6273e3455e95f59d44892)
```JAVA
@Entity
public class Student {
	@GenericGenerator(name="student_id", strategy="com.fuppino.springdata.idgenerators.custom.CustomRandomIDGenerator")
	@Id
	@GeneratedValue(generator="student_id")
	private Long id;
	private String name;
	... getter and setter
}
```

### Finder methods ###
- Spring JPA provides abstract finder methods to get the data based on columns
- we need to add findBy* methods in repository and use it; 
- List<Product> findByName(String name);
[ref](https://github.com/dvinay/spring-jpa-crash-course/commit/eaa17f8452c2d5097ca2e9d1a07511b26d29e4b1)
- for more finder methods [ref](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repository-query-keywords) [ref](https://github.com/dvinay/spring-jpa-crash-course/commit/5a081fa512b83730a8721db342234fe7586315b2)

### Paging and Sorting methods ###
- to eanble paging and sorting for your entity; repository interface must extend PagingAndSortingRepository interface
- PagingAndSortingRepository is a child interface of CrudRepository
- To use paging methods, we need to pass Pageable or Sort object while calling the finder methods[ref](https://github.com/dvinay/spring-jpa-crash-course/commit/4ec0ef44da6aac2e722f3fcb3e9d91cc3e09fbf1)
```JAVA
//Pageing
Pageable pageable = new PageRequest(1,2);
Page<Product> products = productRepository.findAll(pageable );
products.forEach(p -> System.out.println(p.getName()));

//Sorting
Iterable<Product> products = productRepository.findAll(new Sort(Direction.DESC,"name"));
products.forEach(p -> System.out.println(p.getName()));
```

### JPQL ###
- Java Persistence Query Language used to perform database table operations against Domain Objects
- By using JPQL we can perform complex query operations. These queries are converting by ORM tools into SQL.
- to run a basic query using jpql, we can use @Query annotation and pass the jpql as parameter
```JAVA
public interface StudentRepository extends CrudRepository<Student, Long>{	
	@Query("from Student")
	List<Student> findAllStudents();
}
``` 
- we get partial data from the table; @Query return as List<Object[]>
[ref](https://github.com/dvinay/spring-jpa-crash-course/commit/5f6ae64d287286c00144bd9bbdf1fe10167aa037)
- Note: while using jpql for data change operations like delete, we need to add @Modifying annotation for the function and @Transactional before using the delete function
[ref](https://github.com/dvinay/spring-jpa-crash-course/commit/3e61fc4caaa23bddc14ff32c40fbffe16d86c67f)
- by adding Pageable object to function and passing pagerequst;  we can adapt paging and sorting for queries.
[ref](https://github.com/dvinay/spring-jpa-crash-course/commit/64f6da9e505a31229bf8951de99a1b683301ba7a)

### Native SQL Queries ###
- Native SQL Queries are used to perform complex query operations and write queries in SQL format.If JPQL queries are difficult to write like joining multiple jobs
- we can write create statements also like Table, db creation
- for Native SQL Queries also, we need to use @Query with nativeQuery boolean parameter as true
```JAVA
@Query(nativeQuery=true, value="select * from student")
List<Student> findAllStudentsNQ();
```
[ref](https://github.com/dvinay/spring-jpa-crash-course/commit/4df614c25cbec78895e23c764e7884de052206d1)

### Inheritance Mapping ###
- If we have some fileds are common in multple tables, we can divide them like Object oriented Parent Child relation ship
- by using Inheritance Mapping, we can apply parent and child relationship from Object Oriented principle to Database; this is called Sub-Type problem in ORM
- e.g: 
	Payment {id, amount} 
		->Card extends Payment {cardnumber}
		->Check extends Payment {checknumber}
- JPA provide three strategies to solve
	- SINGLE_TABLE 
	- TABLE_PER_CLASS
	- JOINED

- SINGLE_TABLE, all the information store in single table; while implmenting this strategy, we need to provide Discrimintor column to differentiate child types
- to implement this strategy, we use @DiscriminatorColumn and @DiscriminatorValue
[ref](https://github.com/dvinay/spring-jpa-crash-course/commit/62c445be409b9b6d35c2abdfae860e9ff7ae9aeb)

- TABLE_PER_CLASS, as name suggest it divide each class as a seperate table except the parent class; parent class data fields are duplicate to each child class.
- It increases the duplicate columns into multiple tables; but reduce the read opearation
[ref](https://github.com/dvinay/spring-jpa-crash-course/commit/4d54ad237059b14adf4a698fd5b28997d0657076)

- JOINED, uses each class as a seperate table with foreign key as ref between tables.
- Joined is best approach; it follows the database normalization and less data with proper reference key
- To refer the primary key and foreignkey relation ship; we need to use @PrimaryKeyJoinColumn(name="parentclass_id") annotation
- after runnning this child class insertion; it will create a column in parent table and ref to child table










