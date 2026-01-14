import numpy as np
import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression
from sklearn.metrics import r2_score

# ------------------------------------------------
# Load Florida Crime Dataset
# ------------------------------------------------
df = pd.read_csv("flcrime.csv")

X = df[['high_school', 'urban', 'median_income']].values
y = df['crime_rate'].values

# ------------------------------------------------
# Train–Test Split (80:20)
# ------------------------------------------------
X_train, X_test, y_train, y_test = train_test_split(
    X, y, test_size=0.2, random_state=42
)

# ------------------------------------------------
# Train Multiple Linear Regression Model (OLS)
# ------------------------------------------------
model = LinearRegression()
model.fit(X_train, y_train)

y_pred = model.predict(X_test)

# ------------------------------------------------
# Basic Parameters
# ------------------------------------------------
n = len(y_test)
p = X_test.shape[1]
y_mean = np.mean(y_test)

# ------------------------------------------------
# Sum of Squares
# ------------------------------------------------
SSE = np.sum((y_test - y_pred) ** 2)
SSR = np.sum((y_pred - y_mean) ** 2)
SST = np.sum((y_test - y_mean) ** 2)

# ------------------------------------------------
# R² and Adjusted R²
# ------------------------------------------------
R2 = r2_score(y_test, y_pred)
Adj_R2 = 1 - (1 - R2) * (n - 1) / (n - p - 1)

# ------------------------------------------------
# F-statistic
# ------------------------------------------------
MSR = SSR / p
MSE = SSE / (n - p - 1)
F_stat = MSR / MSE

# ------------------------------------------------
# ANOVA Table
# ------------------------------------------------
anova_table = pd.DataFrame({
    "Source": ["Regression", "Error", "Total"],
    "SS": [SSR, SSE, SST],
    "df": [p, n - p - 1, n - 1],
    "MS": [MSR, MSE, ""],
    "F": [F_stat, "", ""]
})

# ------------------------------------------------
# Output Results
# ------------------------------------------------
print("\nRegression Coefficients")
print("------------------------")
print("Intercept:", round(model.intercept_, 4))
print("X1 (High School %):", round(model.coef_[0], 4))
print("X2 (Urban %):", round(model.coef_[1], 4))
print("X3 (Median Income):", round(model.coef_[2], 4))

print("\nModel Evaluation")
print("------------------------")
print("SSE:", round(SSE, 4))
print("SSR:", round(SSR, 4))
print("R²:", round(R2, 4))
print("Adjusted R²:", round(Adj_R2, 4))
print("F-statistic:", round(F_stat, 4))

print("\nANOVA Table")
print("------------------------")
print(anova_table)