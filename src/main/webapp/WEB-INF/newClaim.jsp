<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/header.jsp" %>

<section class="dashboard-section">
    <div class="row dashboard-nowrap">
        <div class="m-4 p-3 width-medium">
            <div class="dashboard-content border-dashed p-3 m-4 view-height">
                <form action="<c:url value="/app/recipe/plan/add"/>" method="post">
                    <div class="row border-bottom border-3 p-1 m-1">
                            <h3 class="color-header">Please fill the form to calculate reimbursement</h3>
                    </div>
                    <div class="schedules-content">
                        <div class="form-group row">
                            <label for="choosePlan" class="col-sm-3 label-size col-form-label">
                                Receipt no. 1
                            </label>
                            <div class="col-sm-3">
                                <select class="form-control" id="choosePlan" name="choosePlan">
                                    <c:forEach var="plan" items="${userPlans}">
                                        <option value="${plan.id}">${plan.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="name" class="col-sm-2 label-size col-form-label">
                                Nazwa posiłku
                            </label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" value="" id="name" placeholder="Nazwa posiłku" name="name">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="number" class="col-sm-2 label-size col-form-label">
                                Numer posiłku
                            </label>
                            <div class="col-sm-2">
                                <input type="number" class="form-control" value="" id="number" placeholder="Numer posiłku" name="displayOrder">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="recipe" class="col-sm-2 label-size col-form-label">
                                Przepis
                            </label>
                            <div class="col-sm-4">
                                <select class="form-control" id="recipe" name="recipe">
                                    <c:forEach var="recipe" items="${userRecipes}">
                                        <option value="${recipe.id}">${recipe.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="day" class="col-sm-2 label-size col-form-label">
                                Dzień
                            </label>
                            <div class="col-sm-2">
                                <select class="form-control" id="day" name="day">
                                    <c:forEach var="day" items="${dayNames}">
                                        <option value="${day.id}">${day.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-success rounded-0 pt-0 pb-0 pr-4 pl-4">Calculate</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>
</body>
</html>
