const express = require("express");
const path = require("path");

const router = express.Router();

function showDailyCheckPage(req, res) {
  res.sendFile(path.join(__dirname, "../views/check/daily.html"));
}

function submitDailyCheck(req, res) {
  // TODO: 구현 및 단위시험 예정
}

router.get("/daily", showDailyCheckPage);
router.post("/daily", submitDailyCheck);

module.exports = router;