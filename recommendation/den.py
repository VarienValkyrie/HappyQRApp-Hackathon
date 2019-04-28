"""
This module descibes how to load a custom dataset from a single file.

As a custom dataset we will actually use the movielens-100k dataset, but act as
if it were not built-in.
"""
from __future__ import (absolute_import, division, print_function,
                        unicode_literals)
from random import randint

from collections import defaultdict
from surprise import SVD
from surprise import Dataset
import pandas as pd
import os
from surprise import BaselineOnly
from surprise import Dataset
from surprise import Reader
from surprise.model_selection import cross_validate




def init():
    gift = pd.read_csv('gifts.csv', sep ="::", engine='python', error_bad_lines=False)
    pd.options.mode.chained_assignment = None
    gift = gift.drop(columns='title')
    return gift;

    genres = {
        'Action': 'Love',
        'Adventure': 'Faith',
        'Animation': 'Heart',
        "Children's": 'Proud',
        "Comedy": 'Hot Love',
        "Crime": "Cleaning",
        "Documentary": "Revolt",
        "Drama": "Sincerety",
        "Fantasy": "Sadness",
        "Film-Noir": "Understanding",
        "Horror": "Youth",
        "Musical": "Elegance",
        "Mystery": "Optimism",
        "Romance": "Confidence",
        "Sci-Fi": "Hope",
        "Thriller": "Unrequited Love",
        "War": "Purity",
        "Western": "Loyalty"
    }
    '''
    i = 0
    replacing = ""
    for r in gift['genre'].str.split("|"):
        k = 0
        for elt in r:
            replacing += genres.get(elt)
            if k < len(r) - 1:
                replacing += '|'
                k += 1
        gift['genre'][i] = replacing.split("|")

        replacing = ""
        i += 1
    '''

    i = 0

    for r in gift['genre'].str.split("|"):
        gift['genre'][i] = genres.get(r[randint(0, len(r)-1)])
        i += 1


def get_top_n(predictions, gift, n=3):
    '''Return the top-N recommendation for each user from a set of predictions.

    Args:
        predictions(list of Prediction objects): The list of predictions, as
            returned by the test method of an algorithm.
        n(int): The number of recommendation to output for each user. Default
            is 10.

    Returns:
    A dict where keys are user (raw) ids and values are lists of tuples:
        [(raw item id, rating estimation), ...] of size n.
    '''

    # First map the predictions to each user.
    top_n = defaultdict(list)
    for uid, iid, true_r, est, _ in predictions:
        top_n[uid].append((iid, est))

    # Then sort the predictions for each user and retrieve the k highest ones.
    for uid, user_ratings in top_n.items():
        user_ratings.sort(key=lambda x: x[1], reverse=True)
        top_n[uid] = user_ratings[:n]

    return top_n

def train(gift):
    # path to dataset file
    file_path = os.path.expanduser('~/.surprise_data/ml-100k/ml-100k/u.data')

    # As we're loading a custom dataset, we need to define a reader. In the
    # movielens-100k dataset, each line has the following format:
    # 'user item rating timestamp', separated by '\t' characters.
    reader = Reader(line_format='user item rating timestamp', sep='\t')

    data = Dataset.load_from_file(file_path, reader=reader)


    trainset = data.build_full_trainset()
    algo = SVD()
    algo.fit(trainset)

    # Than predict ratings for all pairs (u, i) that are NOT in the training set.
    testset = trainset.build_anti_testset()
    predictions = algo.test(testset)

    top_n = get_top_n(predictions, gift)
    return top_n

# Print the recommended items for each user
def get_recommendations(id, top_n, recommendations):

    for uid, user_ratings in top_n.items():
        user_ID = "".format(uid)
        recs = [iid for (iid, _) in user_ratings]
        if int(uid) == int(id):
            recommendations = [
                {
                    "itemID_1": "{}".format(recs[0]),
                    "itemID_2": "{}".format(recs[1]),
                    "itemID_3": "{}".format(recs[2])
                }
            ]
        else:
            recommendations = [
                {
                    "itemID_1": "{}".format(recs[0]),
                    "itemID_2": "{}".format(recs[1]),
                    "itemID_3": "{}".format(recs[2])
                }
            ]

        return recommendations



'''
        for id in gift['giftId']:
            if iid == id:
                top_n[uid].append(gift['genre'][id])
'''
