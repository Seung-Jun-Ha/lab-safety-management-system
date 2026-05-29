const express = require("express");
const path = require("path");

const router = express.Router();

function showSafetyRatingPage(req, res) {
  res.sendFile(path.join(__dirname, "../views/lab/safety-rating.html"));
}

function submitSafetyRating(req, res) {
  // TODO: 구현 및 단위시험 예정
}

router.get("/", showSafetyRatingPage);
router.post("/", submitSafetyRating);

module.exports = router;