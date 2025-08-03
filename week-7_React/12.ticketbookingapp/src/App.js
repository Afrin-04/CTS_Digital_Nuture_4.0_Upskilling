import React, { useState } from 'react';
import GuestPage from './components/GuestPage';
import UserPage from './components/UserPage';
import './App.css';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const button = isLoggedIn ? (
    <button onClick={() => setIsLoggedIn(false)}>Logout</button>
  ) : (
    <button onClick={() => setIsLoggedIn(true)}>Login</button>
  );

  const page = isLoggedIn ? <UserPage /> : <GuestPage />;

  return (
    <div className="App">
      <h1>Ticket Booking App</h1>
      {button}
      <hr />
      {page}
    </div>
  );
}

export default App;
