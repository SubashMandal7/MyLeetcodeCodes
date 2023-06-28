class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> combination,
            List<List<Integer>> result) {
        if (target < 0) {
            return; // If target becomes negative, backtrack.
        } else if (target == 0) {
            result.add(new ArrayList<>(combination)); // Combination found, add it to the result.
        } else {
            for (int i = start; i < candidates.length; i++) {
                combination.add(candidates[i]); // Choose the current candidate.
                // Continue with the same candidate since it can be chosen multiple times.
                backtrack(candidates, target - candidates[i], i, combination, result);
                combination.remove(combination.size() - 1); // Backtrack and remove the last chosen candidate.
            }
        }
    }
}
