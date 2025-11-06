# Application de Gestion de Camping - Projet Pédagogique Java Spring

## 📋 Objectif du Projet

Ce projet pédagogique a pour objectif de développer une application web de gestion de camping en utilisant le framework **Spring MVC**. L'application permet de gérer :

- **Les clients** : gestion des informations clients et utilisateurs
- **Les hébergements** : gestion des emplacements et types d'hébergements
- **Les réservations** : création et suivi des réservations
- **Les services** : gestion des services proposés par le camping
- **Les factures** : génération et suivi des factures et échéances
- **La participation** : gestion de la participation des clients aux services

L'application suit une architecture **MVC (Model-View-Controller)** avec une couche de services et des repositories pour l'accès aux données. Elle utilise **Spring JDBC** pour la persistance des données et expose une **API REST** documentée avec **SpringDoc OpenAPI**.

## 🛠️ Technologies Utilisées

- **Java 17**
- **Spring Framework 6.1.13** (Spring MVC, Spring JDBC, Spring Context)
- **Maven** (gestion des dépendances)
- **MySQL 8.0** (base de données)
- **Lombok** (réduction du code)
- **SpringDoc OpenAPI** (documentation de l'API)
- **Jackson** (sérialisation/désérialisation JSON)
- **Tomcat 11** (serveur d'application)

## 📦 Prérequis

Avant de lancer le projet, assurez-vous d'avoir installé les éléments suivants sur votre ordinateur :

### 1. Java Development Kit (JDK)
- **Version requise** : JDK 17 ou supérieur
- **Vérification** : 
  ```bash
  java -version
  ```
- **Téléchargement** : [Oracle JDK](https://www.oracle.com/java/technologies/downloads/#java17) ou [OpenJDK](https://adoptium.net/)

### 2. Apache Maven
- **Version requise** : Maven 3.6 ou supérieur
- **Vérification** :
  ```bash
  mvn -version
  ```
- **Téléchargement** : [Apache Maven](https://maven.apache.org/download.cgi)
- **Configuration** : Ajoutez Maven à votre variable d'environnement `PATH`

### 3. MySQL Server
- **Version requise** : MySQL 8.0 ou supérieur
- **Vérification** :
  ```bash
  mysql --version
  ```
- **Téléchargement** : [MySQL Community Server](https://dev.mysql.com/downloads/mysql/)
- **Configuration** : Notez votre nom d'utilisateur et mot de passe MySQL

### 4. Apache Tomcat 11
- **Version requise** : Tomcat 11.0 ou supérieur
- **Téléchargement** : [Apache Tomcat 11](https://tomcat.apache.org/download-11.cgi)
- **Configuration** : 
  - Décompressez l'archive dans un répertoire (ex: `C:\Program Files\Apache Software Foundation\Tomcat 11.0`)
  - Notez le chemin d'installation pour le déploiement

### 5. IDE (Optionnel mais recommandé)
- **IntelliJ IDEA** (Community ou Ultimate)
- **Eclipse IDE for Enterprise Java and Web Developers**
- **Visual Studio Code** avec extensions Java

## 🚀 Étapes de Mise en Place

### Étape 1 : Cloner ou Télécharger le Projet

Si le projet est dans un dépôt Git :
```bash
git clone <url-du-repo>
cd camping
```

Sinon, extrayez l'archive du projet dans un répertoire de votre choix.

### Étape 2 : Configuration de la Base de Données MySQL

1. **Démarrer MySQL Server**
   - Sur Windows : Démarrez le service MySQL depuis les Services Windows
   - Sur Linux/Mac : 
     ```bash
     sudo systemctl start mysql
     # ou
     sudo service mysql start
     ```

2. **Créer la Base de Données**
   - Connectez-vous à MySQL :
     ```bash
     mysql -u root -p
     ```
   - Exécutez le script SQL fourni :
     ```bash
     mysql -u root -p < oui.sql
     ```
     Ou depuis MySQL :
     ```sql
     source oui.sql;
     ```
   - Vérifiez que la base `camping_spring` a été créée :
     ```sql
     SHOW DATABASES;
     USE camping_spring;
     SHOW TABLES;
     ```

### Étape 3 : Configuration de la Connexion à la Base de Données

Modifiez le fichier de configuration `AppConfig.java` si nécessaire :

```24:27:src/main/java/com/cda/camping/config/AppConfig.java
        dataSource.setUrl("jdbc:mysql://localhost:3306/camping_spring");
        dataSource.setUsername("root");
        dataSource.setPassword("");
```

**Important** : Remplacez `root` et le mot de passe vide par vos identifiants MySQL si nécessaire.

### Étape 4 : Compilation du Projet avec Maven

1. **Ouvrir un terminal** dans le répertoire racine du projet (`camping`)

2. **Compiler le projet** :
   ```bash
   mvn clean compile
   ```

3. **Générer le fichier WAR** :
   ```bash
   mvn clean package
   ```

   Le fichier `camping.war` sera généré dans le répertoire `target/`.

### Étape 5 : Vérification de la Compilation

Vérifiez que le fichier WAR a été créé :
```bash
# Sur Windows
dir target\camping.war

# Sur Linux/Mac
ls -lh target/camping.war
```

## 🚢 Déploiement sur Tomcat 11

### Méthode 1 : Déploiement Manuel (Recommandé pour le développement)

1. **Arrêter Tomcat** (s'il est en cours d'exécution)
   - Sur Windows : Utilisez le script `shutdown.bat` dans le répertoire `bin` de Tomcat
   - Sur Linux/Mac : 
     ```bash
     $CATALINA_HOME/bin/shutdown.sh
     ```

2. **Copier le fichier WAR**
   - Copiez le fichier `target/camping.war` dans le répertoire `webapps` de Tomcat :
     ```bash
     # Sur Windows
     copy target\camping.war "C:\Program Files\Apache Software Foundation\Tomcat 11.0\webapps\"
     
     # Sur Linux/Mac
     cp target/camping.war $CATALINA_HOME/webapps/
     ```

3. **Démarrer Tomcat**
   - Sur Windows : Exécutez `startup.bat` dans le répertoire `bin` de Tomcat
   - Sur Linux/Mac :
     ```bash
     $CATALINA_HOME/bin/startup.sh
     ```

4. **Vérifier le Déploiement**
   - Ouvrez un navigateur et accédez à : `http://localhost:8080/camping`
   - Vous devriez voir l'application déployée
   - La documentation Swagger/OpenAPI est accessible à : `http://localhost:8080/camping/swagger-ui.html`

### Méthode 2 : Déploiement via l'Interface Manager de Tomcat

1. **Configurer l'utilisateur Manager**
   - Éditez le fichier `conf/tomcat-users.xml` de Tomcat
   - Ajoutez un utilisateur avec les rôles `manager-gui` et `manager-script` :
     ```xml
     <role rolename="manager-gui"/>
     <role rolename="manager-script"/>
     <user username="admin" password="admin" roles="manager-gui,manager-script"/>
     ```

2. **Accéder à l'Interface Manager**
   - Ouvrez : `http://localhost:8080/manager/html`
   - Connectez-vous avec les identifiants configurés

3. **Déployer l'Application**
   - Dans la section "WAR file to deploy", sélectionnez le fichier `target/camping.war`
   - Cliquez sur "Deploy"


## 📡 Utilisation de l'API

### Endpoints Principaux

L'application expose plusieurs endpoints REST :

- **Clients** : `/api/clients`
- **Réservations** : `/api/reservations`
- **Hébergements** : `/api/hebergements`
- **Services** : `/api/services`
- **Factures** : `/api/factures`
- **Échéances** : `/api/echeances`
- **Types** : `/api/types`
- **Users** : `/api/users`

### Documentation API (Swagger)

Une fois l'application déployée, accédez à la documentation interactive :
- **URL** : `http://localhost:8080/camping/swagger-ui.html`
- **API JSON** : `http://localhost:8080/camping/v3/api-docs`

### Exemple de Requête

Testez l'endpoint de démonstration :
```bash
curl http://localhost:8080/camping/api/demo
```

## 🔧 Configuration Avancée

### Changer le Port de Tomcat

Éditez le fichier `conf/server.xml` de Tomcat et modifiez le port dans la balise `<Connector>` :
```xml
<Connector port="8080" protocol="HTTP/1.1"
           connectionTimeout="20000"
           redirectPort="8443" />
```

### Variables d'Environnement

Pour une configuration plus flexible, vous pouvez externaliser la configuration de la base de données dans un fichier de propriétés et le charger dans `AppConfig.java`.

## 🐛 Dépannage

### Problème : Erreur de connexion à la base de données
- Vérifiez que MySQL est démarré
- Vérifiez les identifiants dans `AppConfig.java`
- Vérifiez que la base `camping_spring` existe

### Problème : Port 8080 déjà utilisé
- Changez le port de Tomcat (voir Configuration Avancée)
- Ou arrêtez l'application utilisant le port 8080

### Problème : Erreur 404 après déploiement
- Vérifiez que le fichier WAR est bien dans `webapps`
- Vérifiez les logs de Tomcat dans `logs/catalina.out`
- Vérifiez que le contexte est bien `/camping`

### Problème : Erreur de compilation Maven
- Vérifiez que Java 17 est bien configuré : `java -version`
- Vérifiez que Maven est bien installé : `mvn -version`
- Nettoyez et recompilez : `mvn clean install`

## 📚 Structure du Projet

```
camping/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/cda/camping/
│   │   │       ├── App.java                    # Point d'entrée Spring MVC
│   │   │       ├── config/                      # Configuration Spring
│   │   │       │   ├── AppConfig.java          # Configuration principale
│   │   │       │   └── OpenApiConfig.java       # Configuration OpenAPI
│   │   │       ├── controller/                 # Contrôleurs REST
│   │   │       ├── model/                       # Entités JPA
│   │   │       ├── repository/                  # Accès aux données
│   │   │       └── service/                     # Logique métier
│   │   └── webapp/
│   │       └── WEB-INF/
│   └── test/
├── target/                                      # Fichiers compilés
├── pom.xml                                      # Configuration Maven
├── oui.sql                                      # Script de création de la BDD
└── README.md                                    # Ce fichier
```

## 📝 Notes Importantes

- Ce projet utilise **Spring MVC** (pas Spring Boot), donc le déploiement se fait via un fichier WAR sur un serveur d'application externe
- Le packaging est configuré en **WAR** dans le `pom.xml`
- L'application utilise **Spring JDBC** pour l'accès aux données (pas JPA/Hibernate)
- La documentation OpenAPI est générée automatiquement grâce à SpringDoc

## 👥 Auteur

Projet pédagogique développé dans le cadre de la formation CDA 2025 - Spring Framework.

## 📄 Licence

Ce projet est à usage pédagogique.

