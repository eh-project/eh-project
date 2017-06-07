package com.ehais.figoarticle.model;

import java.util.ArrayList;
import java.util.List;
import org.ehais.tools.CriteriaObject;

public class HaiWebsiteExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table hai_website
     *
     * @mbg.generated Sat Jun 03 18:53:36 CST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table hai_website
     *
     * @mbg.generated Sat Jun 03 18:53:36 CST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table hai_website
     *
     * @mbg.generated Sat Jun 03 18:53:36 CST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table hai_website
     *
     * @mbg.generated Sat Jun 03 18:53:36 CST 2017
     */
    protected int limitStart = -1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table hai_website
     *
     * @mbg.generated Sat Jun 03 18:53:36 CST 2017
     */
    protected int limitEnd = -1;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_website
     *
     * @mbg.generated Sat Jun 03 18:53:36 CST 2017
     */
    public HaiWebsiteExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_website
     *
     * @mbg.generated Sat Jun 03 18:53:36 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_website
     *
     * @mbg.generated Sat Jun 03 18:53:36 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_website
     *
     * @mbg.generated Sat Jun 03 18:53:36 CST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_website
     *
     * @mbg.generated Sat Jun 03 18:53:36 CST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_website
     *
     * @mbg.generated Sat Jun 03 18:53:36 CST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_website
     *
     * @mbg.generated Sat Jun 03 18:53:36 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_website
     *
     * @mbg.generated Sat Jun 03 18:53:36 CST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_website
     *
     * @mbg.generated Sat Jun 03 18:53:36 CST 2017
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_website
     *
     * @mbg.generated Sat Jun 03 18:53:36 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_website
     *
     * @mbg.generated Sat Jun 03 18:53:36 CST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }


    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_website
     *
     * @mbg.generated Sat Jun 03 18:53:36 CST 2017
     */
    public void setLimitStart(int limitStart) {
        this.limitStart=limitStart;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_website
     *
     * @mbg.generated Sat Jun 03 18:53:36 CST 2017
     */
    public int getLimitStart() {
        return limitStart;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_website
     *
     * @mbg.generated Sat Jun 03 18:53:36 CST 2017
     */
    public void setLimitEnd(int limitEnd) {
        this.limitEnd=limitEnd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hai_website
     *
     * @mbg.generated Sat Jun 03 18:53:36 CST 2017
     */
    public int getLimitEnd() {
        return limitEnd;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table hai_website
     *
     * @mbg.generated Sat Jun 03 18:53:36 CST 2017
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andWebsiteIdIsNull() {
            addCriterion("website_id is null");
            return (Criteria) this;
        }

        public Criteria andWebsiteIdIsNotNull() {
            addCriterion("website_id is not null");
            return (Criteria) this;
        }

        public Criteria andWebsiteIdEqualTo(Integer value) {
            addCriterion("website_id =", value, "websiteId");
            return (Criteria) this;
        }

        public Criteria andWebsiteIdNotEqualTo(Integer value) {
            addCriterion("website_id <>", value, "websiteId");
            return (Criteria) this;
        }

        public Criteria andWebsiteIdGreaterThan(Integer value) {
            addCriterion("website_id >", value, "websiteId");
            return (Criteria) this;
        }

        public Criteria andWebsiteIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("website_id >=", value, "websiteId");
            return (Criteria) this;
        }

        public Criteria andWebsiteIdLessThan(Integer value) {
            addCriterion("website_id <", value, "websiteId");
            return (Criteria) this;
        }

        public Criteria andWebsiteIdLessThanOrEqualTo(Integer value) {
            addCriterion("website_id <=", value, "websiteId");
            return (Criteria) this;
        }

        public Criteria andWebsiteIdIn(List<Integer> values) {
            addCriterion("website_id in", values, "websiteId");
            return (Criteria) this;
        }

        public Criteria andWebsiteIdNotIn(List<Integer> values) {
            addCriterion("website_id not in", values, "websiteId");
            return (Criteria) this;
        }

        public Criteria andWebsiteIdBetween(Integer value1, Integer value2) {
            addCriterion("website_id between", value1, value2, "websiteId");
            return (Criteria) this;
        }

        public Criteria andWebsiteIdNotBetween(Integer value1, Integer value2) {
            addCriterion("website_id not between", value1, value2, "websiteId");
            return (Criteria) this;
        }

        public Criteria andWebsiteNameIsNull() {
            addCriterion("website_name is null");
            return (Criteria) this;
        }

        public Criteria andWebsiteNameIsNotNull() {
            addCriterion("website_name is not null");
            return (Criteria) this;
        }

        public Criteria andWebsiteNameEqualTo(String value) {
            addCriterion("website_name =", value, "websiteName");
            return (Criteria) this;
        }

        public Criteria andWebsiteNameNotEqualTo(String value) {
            addCriterion("website_name <>", value, "websiteName");
            return (Criteria) this;
        }

        public Criteria andWebsiteNameGreaterThan(String value) {
            addCriterion("website_name >", value, "websiteName");
            return (Criteria) this;
        }

        public Criteria andWebsiteNameGreaterThanOrEqualTo(String value) {
            addCriterion("website_name >=", value, "websiteName");
            return (Criteria) this;
        }

        public Criteria andWebsiteNameLessThan(String value) {
            addCriterion("website_name <", value, "websiteName");
            return (Criteria) this;
        }

        public Criteria andWebsiteNameLessThanOrEqualTo(String value) {
            addCriterion("website_name <=", value, "websiteName");
            return (Criteria) this;
        }

        public Criteria andWebsiteNameLike(String value) {
            addCriterion("website_name like", value, "websiteName");
            return (Criteria) this;
        }

        public Criteria andWebsiteNameNotLike(String value) {
            addCriterion("website_name not like", value, "websiteName");
            return (Criteria) this;
        }

        public Criteria andWebsiteNameIn(List<String> values) {
            addCriterion("website_name in", values, "websiteName");
            return (Criteria) this;
        }

        public Criteria andWebsiteNameNotIn(List<String> values) {
            addCriterion("website_name not in", values, "websiteName");
            return (Criteria) this;
        }

        public Criteria andWebsiteNameBetween(String value1, String value2) {
            addCriterion("website_name between", value1, value2, "websiteName");
            return (Criteria) this;
        }

        public Criteria andWebsiteNameNotBetween(String value1, String value2) {
            addCriterion("website_name not between", value1, value2, "websiteName");
            return (Criteria) this;
        }

        public Criteria andWebsiteDomainIsNull() {
            addCriterion("website_domain is null");
            return (Criteria) this;
        }

        public Criteria andWebsiteDomainIsNotNull() {
            addCriterion("website_domain is not null");
            return (Criteria) this;
        }

        public Criteria andWebsiteDomainEqualTo(String value) {
            addCriterion("website_domain =", value, "websiteDomain");
            return (Criteria) this;
        }

        public Criteria andWebsiteDomainNotEqualTo(String value) {
            addCriterion("website_domain <>", value, "websiteDomain");
            return (Criteria) this;
        }

        public Criteria andWebsiteDomainGreaterThan(String value) {
            addCriterion("website_domain >", value, "websiteDomain");
            return (Criteria) this;
        }

        public Criteria andWebsiteDomainGreaterThanOrEqualTo(String value) {
            addCriterion("website_domain >=", value, "websiteDomain");
            return (Criteria) this;
        }

        public Criteria andWebsiteDomainLessThan(String value) {
            addCriterion("website_domain <", value, "websiteDomain");
            return (Criteria) this;
        }

        public Criteria andWebsiteDomainLessThanOrEqualTo(String value) {
            addCriterion("website_domain <=", value, "websiteDomain");
            return (Criteria) this;
        }

        public Criteria andWebsiteDomainLike(String value) {
            addCriterion("website_domain like", value, "websiteDomain");
            return (Criteria) this;
        }

        public Criteria andWebsiteDomainNotLike(String value) {
            addCriterion("website_domain not like", value, "websiteDomain");
            return (Criteria) this;
        }

        public Criteria andWebsiteDomainIn(List<String> values) {
            addCriterion("website_domain in", values, "websiteDomain");
            return (Criteria) this;
        }

        public Criteria andWebsiteDomainNotIn(List<String> values) {
            addCriterion("website_domain not in", values, "websiteDomain");
            return (Criteria) this;
        }

        public Criteria andWebsiteDomainBetween(String value1, String value2) {
            addCriterion("website_domain between", value1, value2, "websiteDomain");
            return (Criteria) this;
        }

        public Criteria andWebsiteDomainNotBetween(String value1, String value2) {
            addCriterion("website_domain not between", value1, value2, "websiteDomain");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNull() {
            addCriterion("created is null");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNotNull() {
            addCriterion("created is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedEqualTo(Integer value) {
            addCriterion("created =", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotEqualTo(Integer value) {
            addCriterion("created <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(Integer value) {
            addCriterion("created >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(Integer value) {
            addCriterion("created >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(Integer value) {
            addCriterion("created <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(Integer value) {
            addCriterion("created <=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedIn(List<Integer> values) {
            addCriterion("created in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<Integer> values) {
            addCriterion("created not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(Integer value1, Integer value2) {
            addCriterion("created between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(Integer value1, Integer value2) {
            addCriterion("created not between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNull() {
            addCriterion("updated is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNotNull() {
            addCriterion("updated is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedEqualTo(Integer value) {
            addCriterion("updated =", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotEqualTo(Integer value) {
            addCriterion("updated <>", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThan(Integer value) {
            addCriterion("updated >", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThanOrEqualTo(Integer value) {
            addCriterion("updated >=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThan(Integer value) {
            addCriterion("updated <", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThanOrEqualTo(Integer value) {
            addCriterion("updated <=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedIn(List<Integer> values) {
            addCriterion("updated in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotIn(List<Integer> values) {
            addCriterion("updated not in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedBetween(Integer value1, Integer value2) {
            addCriterion("updated between", value1, value2, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotBetween(Integer value1, Integer value2) {
            addCriterion("updated not between", value1, value2, "updated");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNull() {
            addCriterion("deleted is null");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNotNull() {
            addCriterion("deleted is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedEqualTo(Integer value) {
            addCriterion("deleted =", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotEqualTo(Integer value) {
            addCriterion("deleted <>", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThan(Integer value) {
            addCriterion("deleted >", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanOrEqualTo(Integer value) {
            addCriterion("deleted >=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThan(Integer value) {
            addCriterion("deleted <", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanOrEqualTo(Integer value) {
            addCriterion("deleted <=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedIn(List<Integer> values) {
            addCriterion("deleted in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotIn(List<Integer> values) {
            addCriterion("deleted not in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedBetween(Integer value1, Integer value2) {
            addCriterion("deleted between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotBetween(Integer value1, Integer value2) {
            addCriterion("deleted not between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andWebsiteNameLikeInsensitive(String value) {
            addCriterion("upper(website_name) like", value.toUpperCase(), "websiteName");
            return (Criteria) this;
        }

        public Criteria andWebsiteDomainLikeInsensitive(String value) {
            addCriterion("upper(website_domain) like", value.toUpperCase(), "websiteDomain");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table hai_website
     *
     * @mbg.generated do_not_delete_during_merge Sat Jun 03 18:53:36 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table hai_website
     *
     * @mbg.generated Sat Jun 03 18:53:36 CST 2017
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

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

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

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}