# Minor Project SEM-6

# Smart Campus Issue Prioritization & Predictive Resolution System

## 🌟 Inspiration
The idea for Campus Issue Reporter + Auto-Responder came from our own daily experiences as students.
In most colleges, when students face problems like poor Wi-Fi, broken classroom equipment, unclean washrooms, or electrical faults, they usually report them through:

* Verbal complaints
* WhatsApp messages
* Random emails
* Informal communication

These methods are unstructured and often ineffective. Complaints get lost, there is no tracking system, and students never know whether their issue is being resolved or ignored. This
communication gap between students and administration inspired us to create a centralized, transparent, and automated campus issue management system.

---

### Current problem:

* No structured complaint system

* No tracking

* No transparency

* No prioritization logic

* No analytics for administration

### Our Solution:

* Centralized complaint portal

* AI-based categorization

* Automated priority scoring

* Predictive resolution time

* Admin analytics dashboard

* Auto notification system

---

# Key Features

### Student Features

* Report campus issues with description
* Select severity level
* Choose issue location
* Upload image evidence
* Receive AI-generated predictions
* Track reported issues

### Admin Features

* Admin dashboard
* View all reported issues
* Update issue status (Pending / In Progress / Completed)
* View uploaded issue images
* Monitor campus analytics
* Dynamic issue statistics

### AI Features

* Automatic issue categorization
* Automatic priority prediction
* Estimated resolution time prediction
* AI insights from campus data

---

# Technology Stack

## Backend

* Java
* Spring Boot
* REST APIs
* MongoDB Database

## Frontend

* HTML
* CSS
* JavaScript
* Chart.js (for analytics visualization)

## Machine Learning

* Python
* Scikit-Learn
* TF-IDF Vectorization
* Classification Models
* Regression Model

---

# System Architecture Flow

The system follows a layered architecture where user interactions pass through the frontend, backend services, machine learning engine, and database before generating analytics insights.

### Hierarchical Flow

```
Users
│
▼
Frontend (HTML, CSS, JavaScript)
│
▼
Spring Boot Backend (REST APIs)
│
├── ML Prediction Engine (Python, Scikit-Learn)
│
└── MongoDB Database
│
▼
Admin Dashboard & Analytics (Charts, Insights)
```
---

# Machine Learning Pipeline

The ML module performs three predictions:

### 1. Issue Category Prediction

Predicts which department should handle the issue.

Example categories:

* Infrastructure
* Cleanliness & Hygiene
* Technical Issue
* Safety
* Other

Model Used:

### Text Classification

---

### 2. Priority Prediction

Predicts urgency level based on:

* Issue description
* Category
* Severity

Priority Levels:

* Low
* Medium
* High

Model Used:

### Classification Model

---

### 3. Resolution Time Prediction

Estimates how long it will take to resolve the issue.

Example output:

3.8 hours
15 hours
40 hours

Model Used:

### Regression Model

---

# Project Workflow

The following workflow describes how an issue moves through the system from reporting to resolution and analytics.

### Workflow Diagram

```id="gq1wtx"
Student
│
▼
Login / Register
│
▼
Student Dashboard
│
▼
Report Issue
(Description + Severity + Location + Image)
│
▼
Spring Boot Backend
│
▼
Python Machine Learning Engine
│
▼
Prediction Generated
• Issue Category
• Priority Level
• Estimated Resolution Time
│
▼
MongoDB Database
│
▼
Admin Dashboard
│
▼
View Issues & Update Status
(Pending → In Progress → Completed)
│
▼
Analytics Dashboard
(Charts, Insights, Issue Statistics)
```

### Step 1 — Student Reports Issue

Student submits:

* Issue description
* Severity level
* Location
* Image (optional)

---

### Step 2 — ML Prediction

Python ML model predicts:

* Issue Category
* Priority Level
* Estimated Resolution Time

---

### Step 3 — Data Stored in Database

The system stores the issue in MongoDB including:

* Description
* Category
* Priority
* Status
* Image
* Resolution time

---

### Step 4 — Admin Dashboard

Admin can:

* View all issues
* Update status
* Analyze campus problems
* View uploaded evidence

---

### Step 5 — Analytics Dashboard

Admin analytics include:

* Issue category distribution
* Priority distribution
* Issue status statistics
* AI generated insights

---

# Database Structure

Collection: **issues**

Fields stored:

```
id
description
category
priority
severity
location
predictedResolutionTimeHours
status
imageUrl
createdAt
```

Example Document:

```
{
 description: "Smoke coming from lab switch board",
 category: "Safety",
 priority: "High",
 severity: "High",
 location: "Lab",
 predictedResolutionTimeHours: 3.81,
 status: "Pending",
 imageUrl: "switchboard.jpg"
}
```

---

# Project Screens

### Login Page

User authentication for Student and Admin.

### Student Dashboard

Students can report issues and view their reports.

### Report Issue Page

Students submit problem details and upload images.

### Admin Dashboard

Administrators monitor all campus issues.

### Issue Management Page

Admin updates issue status and views images.

### Analytics Dashboard

Displays campus issue insights using charts.

---

# APIs Used

### Create Issue

```
POST /issues/upload
```

Parameters:

* description
* severity
* location
* image

---

### Get All Issues

```
GET /issues/all
```

---

### Update Issue Status

```
PUT /issues/updateStatus/{id}
```

---

### Analytics Data

```
GET /issues/stats
```

---

# Project Directory Structure

```
campusissue
│
├── src/main/java
│   ├── controller
│   ├── model
│   ├── repository
│   ├── service
│
├── src/main/resources
│   ├── static
│   │   ├── css
│   │   ├── js
│   │   ├── images
│   │
│   ├── templates
│
├── CampusML
│   ├── train_category_model.py
│   ├── train_priority_model.py
│   ├── train_resolution_model.py
│   ├── predict_issue.py
│   ├── models (.pkl files)
│
└── README.md
```

---

# Advantages of the System

* Structured issue reporting
* Faster issue prioritization
* Data driven campus management
* Automated AI decision support
* Transparent issue tracking
* Improved campus maintenance efficiency

---

# Future Enhancements

* Email notifications
* Mobile application
* Real-time issue alerts
* Location heatmap of campus issues
* AI based resource allocation
* Issue resolution recommendation system

---

# Author

Project developed as part of Minor Project (Semester 6)

---
