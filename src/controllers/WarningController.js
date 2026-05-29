const express = require("express");
const path = require("path");

const router = express.Router();

function showWarningPage(req, res) {
  res.sendFile(path.join(__dirname, "../views/education/warning.html"));
}

function submitWarning(req, res) {
  // TODO: 구현 및 단위시험 예정
}

router.get("/", showWarningPage);
router.post("/", submitWarning);

module.exports = router;