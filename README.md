
# Modify Details Page - React Application with Course and Image Management

This is a React application that allows users to manage their profile details, courses, and upload/edit their profile image. The application integrates with a backend API to fetch and modify profile data, course details, and image uploads. Axios is used for making HTTP requests.

## Features

- **User Profile Management**:
  - View and edit profile details such as:
    - Employee ID
    - First Name
    - Last Name
    - Email
    - Title
    - Department
  - Upload and view profile images.

- **Course Management**:
  - View the list of courses the user is currently enrolled in.
  - Add or remove courses from the user's enrollment.

- **Messages and Feedback**:
  - Displays success and error messages when actions are performed (e.g., adding/removing courses, saving profile data, uploading an image).

## API Endpoints

The app interacts with the following API endpoints:

- **GET /details**: Fetches the user's profile details.
- **GET /image**: Fetches the user's profile image.
- **POST /modify**: Modifies the user's profile details.
- **POST /upload**: Uploads the user's profile image.
- **GET /myCourses**: Fetches the user's enrolled courses.
- **GET /courses**: Fetches all available courses.
- **POST /addCourses**: Adds a course to the user's list of enrolled courses.
- **POST /deleteCourses**: Removes a course from the user's list of enrolled courses.

## Requirements

- React (v17 or higher)
- Axios (for making HTTP requests)
- Tailwind CSS (optional, used for styling in this project)
- Backend with the following endpoints:
  - `/myCourses`
  - `/courses`
  - `/addCourses`
  - `/deleteCourses`
  - `/details`
  - `/image`
  - `/upload`

## Installation

To install and run the project locally, follow these steps:

1. **Clone the repository**:
   ```bash
   git clone <repository-url>
   ```

2. **Navigate into the project directory**:
   ```bash
   cd <project-directory>
   ```

3. **Install dependencies**:
   ```bash
   npm install
   ```

4. **Start the application**:
   ```bash
   npm start
   ```

   This will start the development server, and you can open the app in your browser at `http://localhost:3000`.

## Usage

- Upon visiting the page, users will see their current profile details and courses.
- The page allows users to:
  - Edit their profile details by clicking on the "Edit Details" button.
  - Upload a profile image via the image input.
  - View their current list of courses and add/remove courses.
  
## Code Explanation

1. **React Component (`ModifyDetailsPage`)**:
   - Uses `useState` to manage states for form data, courses, selected courses, and image uploads.
   - Uses `useEffect` to fetch user data (profile and courses) when the component mounts.
   - Allows toggling between view and edit modes for the profile details.
   - Handles adding/removing courses via API calls.
   - Displays feedback messages based on the results of API calls.

2. **API Integration**:
   - Axios is used to interact with backend endpoints (`/myCourses`, `/courses`, `/addCourses`, `/deleteCourses`, `/image`, `/upload`).
   - Handles asynchronous data fetching and updates the UI accordingly.

3. **File Upload**:
   - Uses a file input to allow users to upload images.
   - On successful upload, the profile image is updated and displayed.

## License

This project is licensed under the MIT License.

