package com.example.demo0422demo.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * mybatis扩展库
 */
public class TBorrowingBookExample {
    /**
     * The Order by clause.
     */
    protected String orderByClause;

    /**
     * The Distinct.
     */
    protected boolean distinct;

    /**
     * The Ored criteria.
     */
    protected List<Criteria> oredCriteria;

    /**
     * Instantiates a new T borrowing book example.
     */
    public TBorrowingBookExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * Sets order by clause.
     *
     * @param orderByClause the order by clause
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * Gets order by clause.
     *
     * @return the order by clause
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * Sets distinct.
     *
     * @param distinct the distinct
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * Is distinct boolean.
     *
     * @return the boolean
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * Gets ored criteria.
     *
     * @return the ored criteria
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * Or.
     *
     * @param criteria the criteria
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * Or criteria.
     *
     * @return the criteria
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * Create criteria criteria.
     *
     * @return the criteria
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * Create criteria internal criteria.
     *
     * @return the criteria
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * Clear.
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * The type Generated criteria.
     */
    protected abstract static class GeneratedCriteria {
        /**
         * The Criteria.
         */
        protected List<Criterion> criteria;

        /**
         * Instantiates a new Generated criteria.
         */
        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        /**
         * Is valid boolean.
         *
         * @return the boolean
         */
        public boolean isValid() {
            return criteria.size() > 0;
        }

        /**
         * Gets all criteria.
         *
         * @return the all criteria
         */
        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        /**
         * Gets criteria.
         *
         * @return the criteria
         */
        public List<Criterion> getCriteria() {
            return criteria;
        }

        /**
         * Add criterion.
         *
         * @param condition the condition
         */
        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        /**
         * Add criterion.
         *
         * @param condition the condition
         * @param value     the value
         * @param property  the property
         */
        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        /**
         * Add criterion.
         *
         * @param condition the condition
         * @param value1    the value 1
         * @param value2    the value 2
         * @param property  the property
         */
        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        /**
         * And id is null criteria.
         *
         * @return the criteria
         */
        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        /**
         * And id is not null criteria.
         *
         * @return the criteria
         */
        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        /**
         * And id equal to criteria.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        /**
         * And id not equal to criteria.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        /**
         * And id greater than criteria.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        /**
         * And id greater than or equal to criteria.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        /**
         * And id less than criteria.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        /**
         * And id less than or equal to criteria.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        /**
         * And id like criteria.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        /**
         * And id not like criteria.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        /**
         * And id in criteria.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        /**
         * And id not in criteria.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        /**
         * And id between criteria.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        /**
         * And id not between criteria.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        /**
         * And book id is null criteria.
         *
         * @return the criteria
         */
        public Criteria andBookIdIsNull() {
            addCriterion("BOOK_ID is null");
            return (Criteria) this;
        }

        /**
         * And book id is not null criteria.
         *
         * @return the criteria
         */
        public Criteria andBookIdIsNotNull() {
            addCriterion("BOOK_ID is not null");
            return (Criteria) this;
        }

        /**
         * And book id equal to criteria.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andBookIdEqualTo(String value) {
            addCriterion("BOOK_ID =", value, "bookId");
            return (Criteria) this;
        }

        /**
         * And book id not equal to criteria.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andBookIdNotEqualTo(String value) {
            addCriterion("BOOK_ID <>", value, "bookId");
            return (Criteria) this;
        }

        /**
         * And book id greater than criteria.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andBookIdGreaterThan(String value) {
            addCriterion("BOOK_ID >", value, "bookId");
            return (Criteria) this;
        }

        /**
         * And book id greater than or equal to criteria.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andBookIdGreaterThanOrEqualTo(String value) {
            addCriterion("BOOK_ID >=", value, "bookId");
            return (Criteria) this;
        }

        /**
         * And book id less than criteria.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andBookIdLessThan(String value) {
            addCriterion("BOOK_ID <", value, "bookId");
            return (Criteria) this;
        }

        /**
         * And book id less than or equal to criteria.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andBookIdLessThanOrEqualTo(String value) {
            addCriterion("BOOK_ID <=", value, "bookId");
            return (Criteria) this;
        }

        /**
         * And book id like criteria.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andBookIdLike(String value) {
            addCriterion("BOOK_ID like", value, "bookId");
            return (Criteria) this;
        }

        /**
         * And book id not like criteria.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andBookIdNotLike(String value) {
            addCriterion("BOOK_ID not like", value, "bookId");
            return (Criteria) this;
        }

        /**
         * And book id in criteria.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andBookIdIn(List<String> values) {
            addCriterion("BOOK_ID in", values, "bookId");
            return (Criteria) this;
        }

        /**
         * And book id not in criteria.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andBookIdNotIn(List<String> values) {
            addCriterion("BOOK_ID not in", values, "bookId");
            return (Criteria) this;
        }

        /**
         * And book id between criteria.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andBookIdBetween(String value1, String value2) {
            addCriterion("BOOK_ID between", value1, value2, "bookId");
            return (Criteria) this;
        }

        /**
         * And book id not between criteria.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andBookIdNotBetween(String value1, String value2) {
            addCriterion("BOOK_ID not between", value1, value2, "bookId");
            return (Criteria) this;
        }

        /**
         * And borrowing time is null criteria.
         *
         * @return the criteria
         */
        public Criteria andBorrowingTimeIsNull() {
            addCriterion("BORROWING_TIME is null");
            return (Criteria) this;
        }

        /**
         * And borrowing time is not null criteria.
         *
         * @return the criteria
         */
        public Criteria andBorrowingTimeIsNotNull() {
            addCriterion("BORROWING_TIME is not null");
            return (Criteria) this;
        }

        /**
         * And borrowing time equal to criteria.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andBorrowingTimeEqualTo(Date value) {
            addCriterion("BORROWING_TIME =", value, "borrowingTime");
            return (Criteria) this;
        }

        /**
         * And borrowing time not equal to criteria.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andBorrowingTimeNotEqualTo(Date value) {
            addCriterion("BORROWING_TIME <>", value, "borrowingTime");
            return (Criteria) this;
        }

        /**
         * And borrowing time greater than criteria.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andBorrowingTimeGreaterThan(Date value) {
            addCriterion("BORROWING_TIME >", value, "borrowingTime");
            return (Criteria) this;
        }

        /**
         * And borrowing time greater than or equal to criteria.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andBorrowingTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("BORROWING_TIME >=", value, "borrowingTime");
            return (Criteria) this;
        }

        /**
         * And borrowing time less than criteria.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andBorrowingTimeLessThan(Date value) {
            addCriterion("BORROWING_TIME <", value, "borrowingTime");
            return (Criteria) this;
        }

        /**
         * And borrowing time less than or equal to criteria.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andBorrowingTimeLessThanOrEqualTo(Date value) {
            addCriterion("BORROWING_TIME <=", value, "borrowingTime");
            return (Criteria) this;
        }

        /**
         * And borrowing time in criteria.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andBorrowingTimeIn(List<Date> values) {
            addCriterion("BORROWING_TIME in", values, "borrowingTime");
            return (Criteria) this;
        }

        /**
         * And borrowing time not in criteria.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andBorrowingTimeNotIn(List<Date> values) {
            addCriterion("BORROWING_TIME not in", values, "borrowingTime");
            return (Criteria) this;
        }

        /**
         * And borrowing time between criteria.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andBorrowingTimeBetween(Date value1, Date value2) {
            addCriterion("BORROWING_TIME between", value1, value2, "borrowingTime");
            return (Criteria) this;
        }

        /**
         * And borrowing time not between criteria.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andBorrowingTimeNotBetween(Date value1, Date value2) {
            addCriterion("BORROWING_TIME not between", value1, value2, "borrowingTime");
            return (Criteria) this;
        }

        /**
         * And user id is null criteria.
         *
         * @return the criteria
         */
        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        /**
         * And user id is not null criteria.
         *
         * @return the criteria
         */
        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        /**
         * And user id equal to criteria.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andUserIdEqualTo(String value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        /**
         * And user id not equal to criteria.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        /**
         * And user id greater than criteria.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        /**
         * And user id greater than or equal to criteria.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        /**
         * And user id less than criteria.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andUserIdLessThan(String value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        /**
         * And user id less than or equal to criteria.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        /**
         * And user id like criteria.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andUserIdLike(String value) {
            addCriterion("USER_ID like", value, "userId");
            return (Criteria) this;
        }

        /**
         * And user id not like criteria.
         *
         * @param value the value
         * @return the criteria
         */
        public Criteria andUserIdNotLike(String value) {
            addCriterion("USER_ID not like", value, "userId");
            return (Criteria) this;
        }

        /**
         * And user id in criteria.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andUserIdIn(List<String> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        /**
         * And user id not in criteria.
         *
         * @param values the values
         * @return the criteria
         */
        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        /**
         * And user id between criteria.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        /**
         * And user id not between criteria.
         *
         * @param value1 the value 1
         * @param value2 the value 2
         * @return the criteria
         */
        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }
    }

    /**
     * The type Criteria.
     */
    public static class Criteria extends GeneratedCriteria {

        /**
         * Instantiates a new Criteria.
         */
        protected Criteria() {
            super();
        }
    }

    /**
     * The type Criterion.
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        /**
         * Gets condition.
         *
         * @return the condition
         */
        public String getCondition() {
            return condition;
        }

        /**
         * Gets value.
         *
         * @return the value
         */
        public Object getValue() {
            return value;
        }

        /**
         * Gets second value.
         *
         * @return the second value
         */
        public Object getSecondValue() {
            return secondValue;
        }

        /**
         * Is no value boolean.
         *
         * @return the boolean
         */
        public boolean isNoValue() {
            return noValue;
        }

        /**
         * Is single value boolean.
         *
         * @return the boolean
         */
        public boolean isSingleValue() {
            return singleValue;
        }

        /**
         * Is between value boolean.
         *
         * @return the boolean
         */
        public boolean isBetweenValue() {
            return betweenValue;
        }

        /**
         * Is list value boolean.
         *
         * @return the boolean
         */
        public boolean isListValue() {
            return listValue;
        }

        /**
         * Gets type handler.
         *
         * @return the type handler
         */
        public String getTypeHandler() {
            return typeHandler;
        }

        /**
         * Instantiates a new Criterion.
         *
         * @param condition the condition
         */
        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        /**
         * Instantiates a new Criterion.
         *
         * @param condition   the condition
         * @param value       the value
         * @param typeHandler the type handler
         */
        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        /**
         * Instantiates a new Criterion.
         *
         * @param condition the condition
         * @param value     the value
         */
        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        /**
         * Instantiates a new Criterion.
         *
         * @param condition   the condition
         * @param value       the value
         * @param secondValue the second value
         * @param typeHandler the type handler
         */
        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        /**
         * Instantiates a new Criterion.
         *
         * @param condition   the condition
         * @param value       the value
         * @param secondValue the second value
         */
        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}