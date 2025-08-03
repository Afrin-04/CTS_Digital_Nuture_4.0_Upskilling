import React, { useState } from "react";
import EmployeesList from "./EmployeesList";
import ThemeContext from "./ThemeContext";
import { EmployeesData } from "./Employee";
import "./App.css"; 

function App() {
  const [theme, setTheme] = useState("light");
  const [selectedEmployee, setSelectedEmployee] = useState(null);

  return (
    <ThemeContext.Provider value={theme}>
      <div>
        <h1>Employee App</h1>

        <label>SELECT A THEME </label>
        <select onChange={(e) => setTheme(e.target.value)} value={theme}>
          <option value="light">Light</option>
          <option value="dark">Dark</option>
        </select>

        <EmployeesList
          employees={EmployeesData}
          onViewDetails={setSelectedEmployee}
        />

        {selectedEmployee && (
          <div style={{ marginTop: "20px" }}>
            <h2>Employee Details</h2>
            <p><strong>Name:</strong> {selectedEmployee.name}</p>
            <p><strong>Email:</strong> {selectedEmployee.email}</p>
            <p><strong>Phone:</strong> {selectedEmployee.phone}</p>
          </div>
        )}
      </div>
    </ThemeContext.Provider>
  );
}

export default App;
