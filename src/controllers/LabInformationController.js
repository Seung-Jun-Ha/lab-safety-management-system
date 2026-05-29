const express = require("express");
const path = require("path");

const router = express.Router();

function showLabInformationPage(req, res) {
  res.sendFile(path.join(__dirname, "../views/lab/register.html"));
}

function submitLabInformation(req, res) {
  // TODO: 구현 및 단위시험 예정
}

router.get("/", showLabInformationPage);
router.post("/", submitLabInformation);

module.exports = router;