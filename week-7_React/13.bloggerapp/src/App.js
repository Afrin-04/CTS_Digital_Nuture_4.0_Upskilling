import React, { useState } from 'react';
import './App.css';
import { books, blogs, courses } from './data';
import BookDetails from './components/BookDetails';
import BlogDetails from './components/BlogDetails';
import CourseDetails from './components/CourseDetails';

function App() {
  const [showBooks, setShowBooks] = useState(true);
  const [showBlogs, setShowBlogs] = useState(true);
  const [showCourses, setShowCourses] = useState(true);

  return (
    <div className="App">
      <h1>Blogger App</h1>

      <div className="controls">
        <button onClick={() => setShowBooks(!showBooks)}>Toggle Book</button>
        <button onClick={() => setShowBlogs(!showBlogs)}>Toggle Blog</button>
        <button onClick={() => setShowCourses(!showCourses)}>Toggle Course</button>
      </div>

      <div className="container">
        {showCourses && <CourseDetails courses={courses} />}
        {showBooks ? <BookDetails books={books} /> : <p>Books Hidden</p>}
        {showBlogs ? <BlogDetails blogs={blogs} /> : null}
      </div>
    </div>
  );
}

export default App;
