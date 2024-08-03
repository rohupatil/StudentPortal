export const authenticateUser = async (username, password) => {
    try {
      const response = await fetch('http://localhost:8090/auth/authenticate', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ username, password }),
      });
  
      if (!response.ok) {
        throw new Error('Authentication failed');
      }
  
      const data = await response.json();
      localStorage.setItem('token', data.jwtToken);
      console.log("data token : ",data.jwtToken,data);
      return data.jwtToken;
    } catch (error) {
      console.error('Error authenticating:', error);
      throw error;
    }
  };
  
  export const getToken = () => localStorage.getItem('token');
  
  export const logout = () => {
    localStorage.removeItem('token');
  };
  