const express = require("express");
const path = require("path");

const router = express.Router();

function showLoginPage(req, res) {
  res.sendFile(path.join(__dirname, "../views/user/login.html"));
}

function submitLogin(req, res) {
  // TODO: 구현 및 단위시험 예정
}

router.get("/", showLoginPage);
router.post("/", submitLogin);

module.exports = router;