<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/header.jsp" %>

<section class="dashboard-section">
    <div class="row dashboard-nowrap">
        <div class="m-4 p-3 width-medium">
            <div class="dashboard-content border-dashed p-3 m-4 view-height">
                <form action="<c:url value="/claim/calculate"/>" method="post">
                    <div class="row border-bottom border-3 p-1 m-1">
                            <h3 class="color-header">Fill the form to calculate business trip reimbursement</h3>
                    </div>
                    <div class="schedules-content">
                        <c:forEach begin="1" end="5" var="sample">
                            <div class="form-group row">
                                <label for="receipt" + ${sample} class="col-sm-3 label-size col-form-label">
                                    Receipt no. ${sample}
                                </label>
                                <div class="col-sm-3">
                                    <select class="form-control" name="type" + ${sample} id="receipt" + ${sample}>
                                        <c:forEach var="type" items="${receiptTypes}">
                                            <option value="${type.id}">${type.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="col-sm-3">
                                    <input type="number" class="form-control" step="0.01" value="" id="number" placeholder="Paid amount ($)" name="displayOrder">
                                </div>
                            </div>
                        </c:forEach>

                        <div class="form-group row">
                            <label for="travelDays" class="col-sm-3 label-size col-form-label">
                                Days in travel
                            </label>
                            <div class="col-sm-3">
                                <input type="number" class="form-control" value="" id="travelDays" name="travelDays">
                            </div>
                            <div class="col-sm-3">
                                Daily rate: 15$
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="carMileage" class="col-sm-3 label-size col-form-label">
                                Personal car mileage
                            </label>
                            <div class="col-sm-3">
                                <input type="number" class="form-control" value="" id="carMileage" name="carMileage">
                            </div>
                            <div class="col-sm-3">
                                Rate: 0.3$/km
                            </div>
                        </div>
                        <button type="submit" class="btn btn-success rounded-0.5 pt-0 pb-0 pr-4 pl-4">Calculate total amount</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>
</body>
</html>
