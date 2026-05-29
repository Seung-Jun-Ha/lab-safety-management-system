const express = require("express");
const path = require("path");

const router = express.Router();

function showRegisterPage(req, res) {
  res.sendFile(path.join(__dirname, "../views/auth/register.html"));
}

function submitRegister(req, res) {
  // TODO: 구현 및 단위시험 예정
}

router.get("/", showRegisterPage);
router.post("/", submitRegister);

module.exports = router;