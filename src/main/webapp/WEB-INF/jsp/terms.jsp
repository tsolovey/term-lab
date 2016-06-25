<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">

<head>
    <title>HMS Demo</title>

    <link rel="stylesheet" href="https://code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">

    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
    <script>
        $(document).ready(function () {
            $("#dialog").dialog({autoOpen: false});
        });

        /**
         * The function generates popup with the list of external links inside the current page.
         * @param termId
         * @param termName
         */
        function generateReferenceWindow(termId, termName) {

            <%-- Option 1: If the list of external resources is the same for all terms--%>
            <%--then it can be stored in properties file and injected by Spring. See 'references' parameter--%>

            getReferencesForTermFromProperties(termName);

            <%-- Option 2: If the list of external resources is unique for each term--%>
            <%--then we can use ajax to load the list of external resources by term id dynamically--%>
            <%--(by calling appropriate web service). See function getReferencesForTerm(termId) --%>

//            getReferencesForTermFromWebService(termId, termName);
        }

        /**
         * The function shows the list of external resources read from the properties file.
         * @param termName
         */
        function getReferencesForTermFromProperties(termName){
            var references = ${references};
            var output = "";
            $.each(references, function (index, reference) {
                output += '<div><a href="#" onclick="' + 'window.open(\''+reference.url + termName +'\')' + '">' + reference.name + '</a></div>';
            });

            $('#dialog').html(output).dialog({title:"References for " + termName}).dialog("open");
        }

        /**
         * The function calls the web service to get the list of external resources by term id.
         * @param termId
         * @param termName
         */
        function getReferencesForTermFromWebService(termId, termName) {
            $.ajax({
                type: "GET",
                url: "/term/resources?termId=" + termId,
                dataType: 'json',
                timeout: 100000,
                success: function (data) {
                    console.log("SUCCESS: ", data);
                    var output = "";
                    $.each(data, function (index, reference) {
                        output += '<div><a href="#" onclick="' + 'window.open(\''+reference.url + termName +'\')' + '">' + reference.name + '</a></div>';
                    });

                    $('#dialog').html(output);
                },
                error: function (e) {
                    console.log("ERROR: ", e);
                    $('#dialog').html('System error occurred. Please try again later.');
                }
            });

            $('#dialog').dialog({title:"References for " + termName}).dialog("open");
        }
    </script>
</head>

<body>

<h2>Medical Terms</h2>

<c:forEach items="${terms}" var="term" varStatus="loop">
    <div><a href="javaScript:{generateReferenceWindow('${term.id}','${term.name}')}"
            id="${term.id}">${term.name} ( ${term.numberOfPatients} )</a></div>
</c:forEach>

<div id="dialog"></div>
</body>

</html>