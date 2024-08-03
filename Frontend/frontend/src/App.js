import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Login from './components/Login';
import UsersList from './components/UsersList';

function App() {
  return (
   <>
   <BrowserRouter>
      <Routes>
        <Route  path='/login' Component={Login}/>
        <Route  path='/dashboard' Component={UsersList}/>

      </Routes>
   </BrowserRouter>
   </>
  );
}

export default App;
