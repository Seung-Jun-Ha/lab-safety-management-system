const express = require("express");
const path = require("path");

const router = express.Router();

function showChemicalRegisterPage(req, res) {
  res.sendFile(path.join(__dirname, "../views/chemical/register.html"));
}

function submitChemicalRegister(req, res) {
  // TODO: 구현 및 단위시험 예정
}

router.get("/", showChemicalRegisterPage);
router.post("/", submitChemicalRegister);

module.exports = router;