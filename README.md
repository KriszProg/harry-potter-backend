## About The Harry Potter Project

This is a school Team Work project to learn how to build a REST API on backend side 
and how to serve a frontend App from it when backend got requests to its endpoints.

The purposes were to:

* get familiar with splitting an application into multiple parts (frontend and backend)
* practice the development of a REST API
* get familiar with how ORM works
* get familiar with features of Spring-Security

## Project Repos
The whole Project consist of <b>2 Repos:</b><br>
1. <b>Frontend Repo:</b> https://github.com/KriszProg/harry-potter-frontend <br>
2. <b>Backend Repo:</b> https://github.com/KriszProg/harry-potter-backend (this repo) <br>

### Features

- You can reach some BASIC information about characters of Harry Potter movie in form of Cards, 
and allows user to filter them based on certain criteria.
- If you want to REACH more DETAIL about the characters, you should register and login, 
OR you can use the following preset values:<br>
  (1) User Name: <b>user</b> | Password: <b>user</b><br>
  (2) User Name: <b>admin</b> | Password: <b>admin</b>
- With the <b>'House Quiz'</b> game you can test how much you are aware of which character 
belongs to which house of Hogwarts. 



### Technologies

We used the following technologies for implementing the project:<br>

* ReactJS
* Spring Boot, Spring-Security
* Project Lombok
* H2 Database
* Hibernate


### How to Download and Try
<br>
1. Open a Terminal on your PC<br>

<br>
2. Create a project folder for <b>Backend</b> somewhere you want:
     
```
mkdir <name-of-your-project-folder-for-backend>
```
    
<br>
 3. Step into the folder:

```
cd <name-of-your-project-folder-for-backend>
```

<br>
4. Clone the <b>Backend Repo</b> (this Repo):

```
//with ssh:
git clone git@github.com:KriszProg/harry-potter-backend.git

//or with https:
git clone https://github.com/KriszProg/harry-potter-backend.git
```

<br>
5. Create <b>'jpa_databases_for_own_projects'</b> folder in the root folder:<br> 
(this is necessary for the database setup)

```
cd ~
mkdir jpa_databases_for_own_projects
```

<br>
6. Open you project folder in your IDE<br>

<br>
7. Go to <b>'HpBakcendApplication'</b> and Run it (with the green play icon)<br>


<br>
8. Now create a project folder for <b>Frontend</b> somewhere you want:

```
mkdir <name-of-your-project-folder-for-frontend>
```

<br>
9. Step into the folder:
   
   ```
   cd <name-of-your-project-folder-for-frontend>
   ```

<br>
10. Clone the <b>Frontend Repo</b>:

```
//with ssh:
git clone git@github.com:KriszProg/harry-potter-frontend.git

//or with https:
git clone https://github.com/KriszProg/harry-potter-frontend.git
```

<br>
11. Open you project folder in your IDE<br>


<br>
12. Open a Terminal inside the IDE and run the App by:

```
npm start
```
