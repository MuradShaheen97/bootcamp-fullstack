# 📺 TV Shows Management System (Django)

A simple and modern Django web application for managing TV shows.  
Users can create, view, update, and delete TV shows with a clean UI built using TailwindCSS.

---

## 🚀 Features

### 📺 TV Shows Module

- ➕ Create new TV shows
- 📄 View all TV shows in a structured table
- 👁 View detailed information for each show
- ✏️ Edit existing TV shows
- 🗑 Delete TV shows securely (POST requests)

### 🎨 UI / UX

- Modern dark-themed interface (Netflix-style vibes)
- Responsive design using TailwindCSS
- Clean table layout for better readability

---

## 🧠 Project Structure

tv_show/
├── models.py # TVShow model + helper functions
├── views.py # Business logic (CRUD operations)
├── urls.py # Application routes
├── templates/
│ └── tv_show/
│ ├── all_shows.html
│ ├── create_new_show.html
│ ├── edit_show.html
│ └── show_tv_information.html

---

## 🗄️ Database Model

### 📺 TVShow

- `title` → CharField (max 255)
- `network` → CharField (max 255)
- `release_date` → DateField
- `description` → TextField
- `created_at` → DateTime (auto-generated)
- `updated_at` → DateTime (auto-updated)

---

## 🔗 Relationships

This project currently uses a **single model (TVShow)** with no relationships.

---

## ⚙️ Installation & Setup

### 1. Clone the repository

```bash
git clone <repo-url>
cd tv-shows-project
2. Create virtual environment
python -m venv env

Activate:

# Windows

env\Scripts\activate
3. Install dependencies
pip install django
4. Run migrations
python manage.py makemigrations
python manage.py migrate
5. Run server
python manage.py runserver
6. Open in browser
http://127.0.0.1:8000/tv_show/
🌐 Main Routes
Route    Method    Description
/tv_show/    GET    Show all TV shows
/tv_show/shows/new/    GET    Show create form
/tv_show/shows/create/    POST    Create new TV show
/tv_show/shows/<id>/    GET    View single TV show
/tv_show/shows/<id>/edit/    GET    Edit TV show form
/tv_show/shows/<id>/update/    POST    Update TV show
/tv_show/shows/<id>/destroy/    POST    Delete TV show
⚙️ Key Functionalities
🧾 Full CRUD system (Create, Read, Update, Delete)
📺 TV show detail management
🧠 Clean separation between views and models
🔐 Secure delete operation using POST method
🎨 Modern UI using TailwindCSS
🛠️ Tech Stack
Python 3
Django Framework
SQLite Database
HTML5
TailwindCSS
⚠️ Notes
Field names in forms MUST match Django view keys exactly
Always include {% csrf_token %} in POST forms
URL names must match {% url %} usage in templates
Template structure must follow templates/tv_show/ pattern
Delete operations should always use POST requests for safety
📷 Screenshots

Add screenshots here

![Home Page](C:\Users\zzeta\OneDrive\Pictures\Screenshots\Screenshot%202026-06-03%20161930.png)
![Show Page](C:\Users\zzeta\OneDrive\Pictures\Screenshots\Screenshot%202026-06-03%20161940.png)
![](C:/Users/zzeta/AppData/Roaming/marktext/images/2026-06-03-16-20-53-image.png)

👨‍💻 Author

Built as a learning project to master:

Django CRUD operations
Template rendering
URL routing system
Backend + frontend integration
TailwindCSS UI design