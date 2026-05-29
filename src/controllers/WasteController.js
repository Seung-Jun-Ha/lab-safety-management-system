const express = require("express");
const path = require("path");

const router = express.Router();

function showWasteRegisterPage(req, res) {
  res.sendFile(path.join(__dirname, "../views/waste/register.html"));
}

function submitWasteRegister(req, res) {
  // TODO: 구현 및 단위시험 예정
}

function showWasteRequestPage(req, res) {
  res.sendFile(path.join(__dirname, "../views/waste/request.html"));
}

function submitWasteRequest(req, res) {
  // TODO: 구현 및 단위시험 예정
}

router.get("/register", showWasteRegisterPage);
router.post("/register", submitWasteRegister);
router.get("/request", showWasteRequestPage);
router.post("/request", submitWasteRequest);

module.exports = router;