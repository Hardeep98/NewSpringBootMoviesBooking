<!DOCTYPE html>
<html>
<link rel="stylesheet" href="/resources/static/css/seat.css">
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="/jQuery-Seat-Charts/jquery.seat-charts.js"></script>

<body>
    <div class="demo">
        <div id="seat-map">
            <div class="front">SCREEN</div>
        </div>
        <div class="booking-details">
            <p>Movie: <span> Gingerclown</span></p>
            <p>Time: <span>November 3, 21:00</span></p>
            <p>Seat: </p>
            <ul id="selected-seats"></ul>
            <p>Tickets: <span id="counter">0</span></p>
            <p>Total: <b>$<span id="total">0</span></b></p>

            <button class="checkout-button">BUY</button>

            <div id="legend"></div>
        </div>
        <div style="clear:both"></div>
    </div>
</body>

</html>
<script src="seat.js">
</script>