import React from 'react';

class ComplaintRegister extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      ename: '',
      complaint: '',
      NumberHolder: ''
    };
  }

  handleChange = (event) => {
    this.setState({
      [event.target.name]: event.target.value
    });
  }

  handleSubmit = (event) => {
    // Generate random transaction ID
    const refId = Math.floor(Math.random() * 100);
    this.setState({ NumberHolder: refId }, () => {
      const msg = `Thanks ${this.state.ename} \nYour Complaint was Submitted.\nTransaction ID is: ${this.state.NumberHolder}`;
      alert(msg);
    });

    event.preventDefault();
  }

  render() {
    return (
      <div style={{ textAlign: 'center', marginTop: '50px' }}>
        <h2 style={{ color: 'red' }}>Register your complaints here!!!</h2>
        <form onSubmit={this.handleSubmit}>
          <div>
            <label>Name: </label>
            <input 
              type="text" 
              name="ename" 
              value={this.state.ename} 
              onChange={this.handleChange} 
              required
            />
          </div>
          <br />
          <div>
            <label>Complaint: </label>
            <textarea 
              name="complaint" 
              value={this.state.complaint} 
              onChange={this.handleChange} 
              required 
            />
          </div>
          <br />
          <button type="submit">Submit</button>
        </form>
      </div>
    );
  }
}
export default ComplaintRegister;
