import { BrowserRouter as Router, Route } from "react-router-dom";

import "./App.css";
import FrontPage from "./layouts/FrontPage";
import Display from "./layouts/Display";
function App() {
  return (
    <div className="App">
      <Router>
        <Route exact path="/" component={FrontPage}></Route>
        <Route exact path="/stock" component={FrontPage}></Route>
        <Route exact path="/price" component={Display}></Route>
      </Router>
    </div>
  );
}

export default App;
