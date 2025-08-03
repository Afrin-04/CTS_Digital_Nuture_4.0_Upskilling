import React from 'react';

const GuestPage = () => {
  return (
    <div>
      <h2>Welcome Guest</h2>
      <p>View the available flights below:</p>
      <ul>
        <li>Flight A - Chennai to Delhi - ₹5000</li>
        <li>Flight B - Mumbai to Kolkata - ₹4500</li>
        <li>Flight C - Bangalore to Hyderabad - ₹3000</li>
      </ul>
      <p><strong>Login to book your tickets.</strong></p>
    </div>
  );
};

export default GuestPage;
