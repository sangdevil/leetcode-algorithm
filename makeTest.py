import random

# 고정된 25개의 숫자 선택 (1 ~ 10^6 범위 내)
fixed_numbers = [random.randint(1, 100) for _ in range(5)]

# 리스트 생성 함수
def generate_list(length=20, zero_count=15, non_zero_count=5):
    values = random.choices(fixed_numbers, k=non_zero_count)  # 25개 숫자 중에서 750개 선택
    rains = values + [0] * zero_count
    random.shuffle(rains)
    return rains

# 5개의 리스트 생성
rains_lists = [generate_list() for _ in range(5)]

for rain in rains_lists:
    print(rain)
