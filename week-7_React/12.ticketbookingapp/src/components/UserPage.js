import React from 'react';

const UserPage = () => {
  const handleBooking = (flightName) => {
    alert(`Ticket booked successfully for ${flightName}!`);
  };

  return (
    <div>
      <h2>Welcome User</h2>
      <p>Available Flights (You can book now):</p>
      <ul>
        <li>
          Flight A - Chennai to Delhi - ₹5000
          <button onClick={() => handleBooking('Flight A')}>Book Now</button>
        </li>
        <li>
          Flight B - Mumbai to Kolkata - ₹4500
          <button onClick={() => handleBooking('Flight B')}>Book Now</button>
        </li>
        <li>
          Flight C - Bangalore to Hyderabad - ₹3000
          <button onClick={() => handleBooking('Flight C')}>Book Now</button>
        </li>
      </ul>
    </div>
  );
};

export default UserPage;
