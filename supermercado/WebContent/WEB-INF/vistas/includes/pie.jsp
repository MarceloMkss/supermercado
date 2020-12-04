<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
</main>
<footer>
	<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #096ebe;">
		<a class="navbar-brand" href="#">&copy; 2020 Marcelo Kleibson</a>
		<div class="navbar-collapse">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item"><a class="nav-link" href="#">Privacidad</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Cookies</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Dónde
						estamos</a></li>
			</ul>
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="#"><i
						class="fab fa-facebook"></i></a></li>
				<li class="nav-item"><a class="nav-link" href="#"><i class="fab fa-twitter"></i></a></li>
				<li class="nav-item"><a class="nav-link" href="#"><i class="fab fa-youtube"></i></a></li>
			</ul>
		</div>
	</nav>
</footer>


 

    <!-- bootStrap.js -->
    <script src="js/jquery-3.5.1.slim.min.js"></script>
    <script type=" bootstrap.bundle.min.js"></script>
    
    <!-- dataTables.js -->
    <script src="js/jquery.dataTables.min.js"></script>
    <script type="dataTables.bootstrap4.min.js"></script>
   
   
    
    <script>
        $(document).ready(function () {
            $('table').DataTable({
                "language": {
                    "url": "js/Spanish.json"
                }
            });
        });
    </script>

</body>
</html>